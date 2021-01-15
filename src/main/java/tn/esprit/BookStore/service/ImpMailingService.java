package tn.esprit.BookStore.service;


import org.springframework.stereotype.Service;
import tn.esprit.BookStore.env.Credentials;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Order;
import tn.esprit.BookStore.model.OrderItem;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author Njaimi Med Aziz
 */
@Service
public class ImpMailingService implements Credentials,MaillingService {
    Properties props;
    Session session;

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
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(order.getUser().getEmail()));

            // Set Subject: header field
            message.setSubject("Your Bookstore Order Receipt" + order.getId());

            // Now set the actual message
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
            // Send message
            Transport.send(message);
            System.out.println("Receipt mail Sent message successfully....");
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
            message.setText(" Bonjour Admin \n Le Stock du livre N°" + B.getId() + " est en repture du stock " + "\n ** DETAIL DU LIVRE ** \n" + B.toString() + "`\n" + "Cordialement");
            System.out.println("Sending out of stock mail ...");

            Transport.send(message);
            System.out.println("Out of stock mail Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    @Override
    public void sendConfirmationEmail(String to, String msg) {
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("Confirmations");
            message.setText(msg);
            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
