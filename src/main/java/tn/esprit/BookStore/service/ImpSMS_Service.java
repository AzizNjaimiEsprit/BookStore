package tn.esprit.BookStore.service;


import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.env.Credentials;
import tn.esprit.BookStore.model.Coupon;
import tn.esprit.BookStore.model.User;

/**
 * @author Njaimi Med Aziz & Mahdi Riahi
 */
@Service
public class ImpSMS_Service implements Credentials, SMS_Service {

    NexmoClient client;

    public ImpSMS_Service() {
        client = NexmoClient.builder()
                .apiKey(nexmo_apiKey)
                .apiSecret(nexmo_apiSecret)
                .build();
    }

    @Override
    public boolean SendSMSCouponGenerated(Coupon coupon) {

        String text = "Hi " + coupon.getUser().getFull_name() + "\nYou generated a payment coupon : " + coupon.getCode() + "\nAmount : " + coupon.getAmount();
        SmsSubmissionResponse responses = client.getSmsClient().submitMessage(new TextMessage(
                "BookStore",
                "216" + coupon.getUser().getTelephone(),
                text));
        for (SmsSubmissionResponseMessage response : responses.getMessages()) {
            System.out.println(response.getStatus());
            if (response.getStatus().equals("OK"))
                return true;
            else
                return false;
        }
        return false;
    }

    @Override
    public boolean SendDeclineSMS(User user) {
        NexmoClient client = NexmoClient.builder()
                .apiKey(nexmo_apiKey)
                .apiSecret(nexmo_apiSecret)
                .build();
        String text = "Hi " + user.getFull_name() + "\nSorry but we are not interested in buying your book.";
        SmsSubmissionResponse responses = client.getSmsClient().submitMessage(new TextMessage(
                "BookStore",
                "216" + user.getTelephone(),
                text));
        for (SmsSubmissionResponseMessage response : responses.getMessages()) {
            System.out.println(response.getStatus());
            return response.getStatus().equals("OK");

        }
        return false;
    }

}
