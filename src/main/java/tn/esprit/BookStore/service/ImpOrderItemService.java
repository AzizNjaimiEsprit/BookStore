package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.OrderItem;
import tn.esprit.BookStore.repository.OrderItemRepository;

import java.util.List;

@Service
public class ImpOrderItemService implements OrderItemService {
    @Autowired
    OrderItemRepository repository;
    @Autowired
    BookService bookService;

    @Transactional
    @Override
    public void add(OrderItem orderItem) {
        Book book = bookService.getBook(orderItem.getBook());
        book.setQuantity(book.getQuantity()- orderItem.getQuantity());
        bookService.updateBook(book);
        repository.save(orderItem);
    }

    @Transactional
    @Override
    public void update(OrderItem orderItem) {
        OrderItem oi = repository.getOne(orderItem.getId());
        int diff = oi.getQuantity() - orderItem.getQuantity();
        Book book = bookService.getBook(orderItem.getBook());
        book.setQuantity(book.getQuantity()+diff);
        bookService.updateBook(book);
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
