package tn.esprit.BookStore;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.BookStore.model.User;
import tn.esprit.BookStore.repository.UserRepository;
import tn.esprit.BookStore.service.IUserService;


@SpringBootTest
@RunWith(SpringRunner.class)
class BookStoreApplicationTests {
@Autowired
IUserService Srv;
@Autowired
UserRepository repo;
	/*@Test
	void testAjouterEntreprise()
	{
		User e=new  User("nourhene", "nourhene", 44654,"nourhene","nourhene",0) ;
		Srv.Signup(e);
	}*/
	
	@Test
	void test()
	{
		


	}
}
