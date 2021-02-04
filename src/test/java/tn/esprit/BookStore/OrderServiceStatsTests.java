package tn.esprit.BookStore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.BookStore.model.*;
import tn.esprit.BookStore.repository.OrderRepository;
import tn.esprit.BookStore.repository.ZipCodesTnRepository;
import tn.esprit.BookStore.service.OrderItemService;
import tn.esprit.BookStore.service.OrderService;
import tn.esprit.BookStore.service.UserService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Med Aziz Njaimi
 */
@SpringBootTest
class OrderServiceStatsTests {
	@Autowired
	OrderService orderService;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderItemService orderItemService;
	@Autowired
	UserService userService;

	@Test
	void contextLoads() {

/*
		//Test Stat Per Gov
		orderService.getStatsPerGov().forEach((k,v)-> System.out.println(k+":"+v));
		//Test Stat Per Quarter
		orderService.getStatsPerQuarter().forEach((k,v)-> System.out.println(k+":"+v));
		//Test Stat Per Month
		orderService.getStatsPerMonth().forEach((k,v)-> System.out.println(k+":"+v));
		//Test Best Customer
		orderService.getBestCustomer().forEach((k,v)-> System.out.println(k+":"+v));
		//Test Best Book
		System.out.println(orderItemService.getBestBook());
 */
		//Test Client Matching
		orderService.getClientsFavouriteCategories().forEach((k,v)-> System.out.println(k+":"+v));


	}

}
