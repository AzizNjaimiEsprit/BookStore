package tn.esprit.BookStore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.messages.TextMessage;
import tn.esprit.BookStore.model.Library;
import tn.esprit.BookStore.model.User;
import tn.esprit.BookStore.repository.UserRepository;
import tn.esprit.BookStore.utility.NexmoConfiguration;

import javax.persistence.EntityNotFoundException;

@Service
public class SmsSenderImp implements SmsSender {

    @Autowired
    NexmoConfiguration nexmoConfiguration;

    @Autowired
    UserRepository userRepo;

    @Override
    public void sendSms(Library library) {
            User user= userRepo.findById(library.getUser().getId());
            if(user == null)
                throw new EntityNotFoundException();

            NexmoClient client = new NexmoClient.Builder()
                    .apiKey(nexmoConfiguration.getApiKey())
                    .apiSecret(nexmoConfiguration.getApiSecret())
                    .build();

            String text = "Congratulation " + user.getFull_name() + " you have received fidelity points from the quiz";
            SmsSubmissionResponse responses = client.getSmsClient().submitMessage(new TextMessage(
                    "BookStore",
                    "216" + user.getTelephone(),
                    text));
    }
}
