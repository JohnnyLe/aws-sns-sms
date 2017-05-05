/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package johnny.sns.sms;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author johnny
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AWSCredentials awsCredentials =new BasicAWSCredentials("accessKey", "secretKey");
        AmazonSNSClient snsClient = new AmazonSNSClient(awsCredentials);
        String message = "My SMS message";
        String phoneNumber = "+84933305363";
        Map<String, MessageAttributeValue> smsAttributes = 
                new HashMap<String, MessageAttributeValue>();
        //<set SMS attributes>
        sendSMSMessage(snsClient, message, phoneNumber, smsAttributes);
    }
    

      public static void sendSMSMessage(AmazonSNSClient snsClient, String message, 
		String phoneNumber, Map<String, MessageAttributeValue> smsAttributes) {
        PublishResult result = snsClient.publish(new PublishRequest()
                        .withMessage(message)
                        .withPhoneNumber(phoneNumber)
                        .withMessageAttributes(smsAttributes));
        System.out.println(result); // Prints the message ID.
}
}
