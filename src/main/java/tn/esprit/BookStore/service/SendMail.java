package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.entities.User;

@Service
public class SendMail {



    private JavaMailSender javaMailSender;

    @Autowired
    public SendMail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(User user , String text) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(user.getEmail());
        msg.setFrom("storebook2021@gmail.com");
        msg.setSubject("Book Recommendation By Nawmsh Store!");
        msg.setText(text);
        javaMailSender.send(msg);
    }
}