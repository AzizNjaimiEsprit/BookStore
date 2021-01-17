package tn.esprit.BookStore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Order;
import tn.esprit.BookStore.model.OrderItem;
import tn.esprit.BookStore.service.OrderItemService;

/**
 * @author Med Aziz Njaimi
 */
@SpringBootTest
class OrderItemServiceTests {
	@Autowired
	OrderItemService oiService;

	@Test
	void contextLoads() {
		System.out.println(oiService.getUnsaledBooks());

		//Test Get All
		System.out.println("********* Get All **********************");
		oiService.getOrderItems().forEach(System.out::println);

		System.out.println("********* Get Order Items **************");
		oiService.getOrderItems(1).forEach(System.out::println);

		System.out.println("********* Get Order Item By Id *********");
		System.out.println(oiService.getOrderItem(2));

		System.out.println("********* Add Order Item ***** *********");
		OrderItem orderItem = new OrderItem(0,new Order(1),5,new Book(37));
		oiService.add(orderItem);

		System.out.println("********* Update Order Item ************");
		orderItem.setQuantity(4);
		oiService.update(orderItem);

	}
	// Test Passed
	/********** Get All **********************
	OrderItem{id=1, orderId=1, quantity=1, bookId=34}
	OrderItem{id=2, orderId=2, quantity=1, bookId=34}
	********* Get Order Items **************
	OrderItem{id=1, orderId=1, quantity=1, bookId=34}
	********* Get Order Item By Id *********
	OrderItem{id=2, orderId=2, quantity=1, bookId=34}
	********* Add Order Item ***** *********

	********** Update Order Item *************/


}
