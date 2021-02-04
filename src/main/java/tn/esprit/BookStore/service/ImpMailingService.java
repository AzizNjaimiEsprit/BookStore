package tn.esprit.BookStore.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.env.Credentials;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Order;
import tn.esprit.BookStore.model.OrderItem;
import tn.esprit.BookStore.model.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author Njaimi Med Aziz
 */
@Service
public class ImpMailingService implements Credentials, MaillingService {
    Properties props;
    Session session;
    private static final Logger log = LoggerFactory.getLogger(ImpMailingService.class);

    public ImpMailingService() {
        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //get Session
        session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });
    }


    @Override
    public void sendReceiptEmail(Order order) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(order.getUser().getEmail()));
            message.setSubject("Your Bookstore Order Receipt" + order.getId());
            String text = "" +
                    "Hi " + order.getUser().getFull_name() + " \n\n" +
                    "Thanks for your purchase from our BookStore \n\n" +
                    "YOUR ORDER INFORMATION: \n\n" +
                    "Order ID: " + order.getId() + "\n\n" +
                    "Payment ID: " + order.getPaymentID() + "\n\n" +
                    "Order Date: " + order.getOrderDate() + "\n\n" +
                    "HERE'S WHAT YOU ORDERED: \n\n";
            for (OrderItem i : order.getItems()) {
                text += i.getBook().getTitle() + "\t Quantity : " + i.getQuantity() + "\n\n";
            }
            text += "Total Price : " + order.getTotalPrice() + "Dt\n\n\n\n" +
                    "Remember that you can always check on you order status on our website www.bookstore.com.tn";
            message.setText(text);
            System.out.println("sending receipt mail...");
            Transport.send(message);
            //System.out.println("Receipt mail Sent message successfully....");
            log.info("Receipt mail Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    @Override
    public void sendGiftEmail(User user, double amount) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            message.setSubject("Best Customer Gift");
            String text = "" +
                    "Hi " + user.getFull_name() + " \n\n" +
                    "You are chosen as Best Customer of the week \n\n" +
                    "As a reward to your fidelity : \n\n" +
                    "A Gift has been sent to your fidelity wallet \n\n" +
                    "Amount : " + amount + "\n\n";
            message.setText(text);
            System.out.println("sending Best Customer Gift mail...");
            Transport.send(message);
            log.info("Best Customer Gift mail Sent successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    @Override
    public void sendReptureStockEmail(Book B) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("samar.neji@esprit.tn"));
            message.setSubject("Alerte : Repture du stock ");
            message.setText(" Bonjour Admin \n Le livre N°" + B.getId() + " est en repture du stock " +
                    "\n ** DETAIL DU LIVRE ** \n" + B.toString() + "`\n" + "Cordialement");
            System.out.println("Sending out of stock mail ...");

            Transport.send(message);
            log.info("Out of stock mail Sent message successfully....");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    @Override
    public void sendMatchingEmail(User u,Book b) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(u.getEmail()));
            message.setSubject("Nouvelle arrivage ");
            message.setText("\n\n Un nouveau livre arrive qui vous peut etre vous parait intéressant \n\n"+
                    "https://bookstore.tn/book/"+b.getId());
            System.out.println("Sending matching mail ...");

            Transport.send(message);
            log.info("match mail Sent message successfully to"+u.getEmail());

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }


    @Override
    public void sendConfirmationEmail(String to, String msg) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Confirmations");
            message.setText(msg);
            System.out.println("sending...");
            Transport.send(message);
            log.info("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
