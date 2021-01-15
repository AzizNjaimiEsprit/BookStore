package tn.esprit.BookStore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Order;
import tn.esprit.BookStore.model.OrderItem;
import tn.esprit.BookStore.model.User;
import tn.esprit.BookStore.service.OrderService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Med Aziz Njaimi
 */
@SpringBootTest
class OrderServiceTests {
	@Autowired
	OrderService orderService;
	@Test
	void contextLoads() {
		//Test Get All
		System.out.println("********* Get All **********************");
		orderService.getOrders().forEach(System.out::println);

		System.out.println("********* Get All By Status ************");
		orderService.getOrders("Non Traite").forEach(System.out::println);

		System.out.println("********* Get User Orders **************");
		orderService.getUserOrders(3).forEach(System.out::println);

		System.out.println("********* Get Order By Id **************");
		System.out.println(orderService.getOrder(2));

		System.out.println("********* Add Order ********************");
		OrderItem orderItem1 = new OrderItem(0,null,5,new Book(37));
		OrderItem orderItem2 = new OrderItem(0,null,2,new Book(36));
		List<OrderItem> list = new ArrayList<>();list.add(orderItem1);list.add(orderItem2);
		User user = new User();
		user.setId(3);
		user.setEmail("a52650101@gmail.com");
		user.setFullName("Med Aziz Njaimi");
		user.setTelephone("52650101");
		Order order = new Order(0,user,list,120,null,"2020-15-02","kbba",2503,"52650101","Non Traite");
		System.out.println(orderService.add(order));

		System.out.println("********* Update Order Status ***********");
		order.setStatus("Traite");
		System.out.println(orderService.updateStatus(order));

		System.out.println("********* Update Order ***** ************");
		order.getItems().get(0).setQuantity(1);
		System.out.println(orderService.update(order));
	}

}
