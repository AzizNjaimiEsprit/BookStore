package tn.esprit.BookStore.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.esprit.BookStore.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ScheduledTasks {

    @Autowired
    OrderService orderService;

    @Autowired
    MaillingService maillingService;

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    OrderItemService orderItemService;


    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    //True Value 604800000 (Week) // Aziz
    @Scheduled(fixedRate = 60000)
    public void sendGifts() {
//        Map<User,Double> bestCus = orderService.getBestCustomer();
//        User user = userService.GetUser(bestCus.keySet().stream().findFirst().get().getId());
//        Double amount = bestCus.values().stream().findFirst().get();
//        double randomNum = ThreadLocalRandom.current().nextInt(10, amount.intValue() + 1);
//        log.info("Gift Sent Successfully to "+user.getFull_name()+" Amount = "+amount+" Gift = "+randomNum);
//        //Fidelity Service Add Points
//        maillingService.sendGiftEmail(user,randomNum);
    }

    // Every Day 1440000 // Samar
    @Scheduled(fixedRate = 60000)
    public void discountUnsaledBooks() {
//        int max = 0;
//        orderItemService.getUnsaledBooks().forEach(book -> {
//            if (! book.isDiscounted()){
//                book.setPrice(book.getPrice()*0.75);
//                log.info(book.getTitle()+" price discounted by 0.25");
//                bookService.updateBook(book);
//            }
//        });
    }

    // Every Day 1440000 // Samar
    @Scheduled(fixedRate = 60000)
    public void checkBestBookStock() {
//        if (orderItemService.getBestBook().getQuantity() < 10){
//            maillingService.sendReptureStockEmail(orderItemService.getBestBook());
//        }
    }
}
