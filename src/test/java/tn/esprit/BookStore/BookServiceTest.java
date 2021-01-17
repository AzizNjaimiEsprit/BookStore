package tn.esprit.BookStore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.BookStore.model.Coupon;
import tn.esprit.BookStore.model.CouponUsageHistory;
import tn.esprit.BookStore.model.Order;
import tn.esprit.BookStore.repository.BookRepository;
import tn.esprit.BookStore.service.BookService;
import tn.esprit.BookStore.service.CouponUsageHistoryService;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookService bookService;

    @Test
    void contextLoads() {
        System.out.println(bookService.getBookByID(34).getTitle());
    }
}
