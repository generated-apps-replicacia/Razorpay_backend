package com.apps.petcare.controller;
import com.apps.petcare.model.SubscriptionEntity;
import com.razorpay.*;
import org.json.JSONObject; // Import the JSONObject class
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RazorpaySubscriptionService {

    @Value("${razorpay.api.key}")
    private String apiKey;

    @Value("${razorpay.api.secret}")
    private String apiSecret;

//    public String createSubscription(SubscriptionEntity subscription) throws RazorpayException {
//        RazorpayClient razorpay = new RazorpayClient(apiKey, apiSecret);
//
//        try {
//            JSONObject subscriptionData = new JSONObject(subscription); // Convert SubscriptionEntity to JSONObject
//            SubscriptionEntity createdSubscription = razorpay.subscriptions.create(subscriptionData);
//            return createdSubscription.get("id");
//        } catch (RazorpayException e) {
//            throw e;
//        }
//    }
    
    public Subscription createSubscription(SubscriptionEntity subscriptionEntity) throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient(apiKey, apiSecret);
        try {			
        	JSONObject subscriptionData = new JSONObject(subscriptionEntity);
//        	subscriptionData.remove("end_at");
//        	subscriptionData.remove("total_count");
        	System.out.println("subscriptionData: "+ subscriptionData);
        	Subscription subscription = razorpay.subscriptions.create(subscriptionData);
//        	Invoice invoice = razorpay.invoices.fetch("inv_Mu0IakSLAKe9Dk");
//        	razorpay.invoices.issue("inv_Mu0IakSLAKe9Dk");
//        	razorpay.invoices.notifyBy("inv_Mu0IakSLAKe9Dk", "sms");
//        	razorpay.invoices.notifyBy("inv_Mu0IakSLAKe9Dk", "email");
//        	System.out.println("Invoice: " + invoice.toString());
        	System.out.println("subscription: "+ subscription);
        	// Add any other subscription details as needed
        	
//        Subscription createdSubscription = razorpay.subscriptions.create(subscription);
        	return subscription;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
    }
}

