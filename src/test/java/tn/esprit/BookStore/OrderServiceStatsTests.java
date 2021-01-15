package tn.esprit.BookStore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Order;
import tn.esprit.BookStore.model.OrderItem;
import tn.esprit.BookStore.model.User;
import tn.esprit.BookStore.repository.OrderRepository;
import tn.esprit.BookStore.repository.ZipCodesTnRepository;
import tn.esprit.BookStore.service.OrderService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Med Aziz Njaimi
 */
@SpringBootTest
class OrderServiceStatsTests {
	@Autowired
	OrderService orderService;
	@Autowired
	OrderRepository orderRepository;
	@Test
	void contextLoads() {
		//Test Stat Per Gov
		orderService.getStatsPerGov().forEach((k,v)-> System.out.println(k+":"+v));
		//Test Stat Per Quarter
		orderService.getStatsPerQuarter().forEach((k,v)-> System.out.println(k+":"+v));
		//Test Stat Per Month
		orderService.getStatsPerMonth().forEach((k,v)-> System.out.println(k+":"+v));
		//Test Best Customer
		orderService.getBestCustomer().forEach((k,v)-> System.out.println(k+":"+v));



	}

}
