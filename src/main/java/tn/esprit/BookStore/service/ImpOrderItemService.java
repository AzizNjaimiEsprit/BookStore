package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.BookStore.model.OrderItem;
import tn.esprit.BookStore.repository.OrderItemRepository;

import java.util.List;

@Service
public class ImpOrderItemService implements OrderItemService {
    @Autowired
    OrderItemRepository repository;

    @Transactional
    @Override
    public void add(OrderItem orderItem) {
        repository.save(orderItem);
    }

    @Transactional
    @Override
    public void update(OrderItem orderItem) {
        repository.save(orderItem);
    }


    @Override
    public List<OrderItem> getOrderItems() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public List<OrderItem> getOrderItems(int orderId) {
        return repository.findAllByOrder(orderId);
    }

    @Transactional
    @Override
    public OrderItem getOrderItem(int orderItemId) {
        return repository.findById(orderItemId).get();
    }

}
