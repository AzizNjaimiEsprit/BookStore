package tn.esprit.BookStore.service;

import com.google.gson.Gson;
import com.stripe.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.BookStore.model.Order;
import tn.esprit.BookStore.model.OrderItem;
import tn.esprit.BookStore.repository.BookRepository;
import tn.esprit.BookStore.repository.OrderRepository;

import java.util.*;

@Service
public class ImpOrderService implements OrderService {
    private final Gson gson = new Gson();
    @Autowired
    PaymentService paymentService;
    @Autowired
    MaillingService mailingService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    BookService bookService;
    @Autowired
    OrderItemService orderItemService;

    @Transactional
    @Override
    public Order add(Order order) {

        //Checking book disponibility
        for (OrderItem item : order.getItems()) {
            if (item.getQuantity() > bookService.getQuantity(item.getBook().getId()))
                return null;
        }
        for (OrderItem item : order.getItems()) {
            if (item.getQuantity() == bookService.getQuantity(item.getBook().getId())) {
                mailingService.sendReptureStockEmail(item.getBook());
            }
        }

        Customer c = paymentService.getCustomer(order.getUser().getEmail());
        String pay_id = paymentService.chargeCustomer(c.getId(), (int) order.getTotalPrice() * 100);
        if (pay_id == null) {
            return null;
        } else {
            order.setPaymentID(pay_id);
        }
        Order insertedOrder = orderRepository.save(order);
        for (OrderItem i : order.getItems()) {
            i.setOrder(insertedOrder);
            orderItemService.add(i);
        }
        mailingService.sendReceiptEmail(insertedOrder);
        System.out.println(insertedOrder);
        return insertedOrder;
    }

    @Transactional
    @Override
    public Order update(Order order) {
        System.out.println("*************** In Update ***************");
        System.out.println(order);
        orderRepository.save(order);
        for (OrderItem i : order.getItems()) {
            i.setOrder(new Order(order.getId()));
            orderItemService.update(i);
        }
        return null;
    }

    @Transactional
    @Override
    public Order updateStatus(Order order) {
        System.out.println("*************** In Update Status ***************");
        orderRepository.updateStatus(order.getStatus(), order.getId());
        return order;
    }


    @Transactional
    @Override
    public Order getOrder(int orderId) {
        Optional<Order> res = orderRepository.findById(orderId);
        if (res.isPresent())
            return res.get();
        else
            return null;
    }

    @Transactional
    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    @Override
    public List<Order> getOrders(String status) {
        return orderRepository.findAllByStatus(status);
    }

    @Transactional
    @Override
    public List<Order> getUserOrders(int userId) {
        return orderRepository.findAllByUser(userId);
    }

    @Transactional
    @Override
    public Map<String, Float> getStatsPerGov() {
        Map<String, Float> res = new HashMap<>();
        ArrayList<String> list = orderRepository.getInputsByGovernorate();
        for (String s : list) {
            res.put(s.split(":")[0], Float.parseFloat(s.split(":")[1]));
        }
        return res;
    }

    @Override
    public Map<Integer, Double> getStatsPerMonth() {
        Map<Integer, Double> res = new HashMap<>();
        List<Object[]> list = orderRepository.getInputsByMonth();
        for (Object[] obj : list) {
            int month = (int) obj[0];
            double sum = (double) obj[1];
            res.put(month, sum);
        }
        return res;
    }

    @Override
    public Map<Integer, Double> getStatsPerQuarter() {
        Map<Integer, Double> res = new HashMap<>();
        List<Object[]> list = orderRepository.getInputsByQuarter();
        for (Object[] obj : list) {
            int quarter = (int) obj[0];
            double sum = (double) obj[1];
            res.put(quarter, sum);
        }
        return res;
    }

    @Override
    public Map<String, Double> getBestCustomer() {
        Map<String, Double> res = new HashMap<>();
        List<Object[]> list = orderRepository.getBestCustomer();
        for (Object[] obj : list) {
            String name = (String) obj[1];
            double sum = (double) obj[0];
            res.put(name, sum);
            return res;
        }
        return null;
    }
}
