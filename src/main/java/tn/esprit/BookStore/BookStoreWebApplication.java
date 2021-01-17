package tn.esprit.BookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tn.esprit.BookStore.service.ScheduledTasks;

@SpringBootApplication
@EnableScheduling
public class BookStoreWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookStoreWebApplication.class, args);
    }
}
