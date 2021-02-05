package tn.esprit.BookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import tn.esprit.BookStore.service.ScheduledTasks;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
@ComponentScan("tn.esprit")
public class BookStoreWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookStoreWebApplication.class, args);
    }
}
