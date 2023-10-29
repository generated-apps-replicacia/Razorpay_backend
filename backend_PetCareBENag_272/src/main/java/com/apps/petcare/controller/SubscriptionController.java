package com.apps.petcare.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.petcare.model.PaymentDetails;
import com.apps.petcare.model.SubscriptionEntity;
import com.razorpay.Invoice;
import com.razorpay.RazorpayException;
import com.razorpay.Subscription;
import com.razorpay.Utils;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("PetCareBENag/subscription")
public class SubscriptionController {
	
	@Autowired
    private RazorpaySubscriptionService razorpayService;
	
	@Value("${razorpay.api.key}")
	String apiKey;
	
	@Value("${razorpay.api.secret}")
	String apiSecret;

	@PostMapping("/razorpay-webhook")
    public void handleRazorpayWebhook(@RequestBody String payload) {
        System.out.println(payload);
    }
	
    @PostMapping
    public ResponseEntity<String> createSubscription(@RequestBody SubscriptionEntity subscription) {
        try {
        	System.out.println("SubscriptionEntity Object: "+subscription.toString());
        	Subscription createdSubscription = razorpayService.createSubscription(subscription);
//            return ResponseEntity.ok("SubscriptionEntity created successfully. SubscriptionEntity: " + createdSubscription);
            return ResponseEntity
	                .ok()
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(createdSubscription.toString());
//            Invoice invoice = razorpayService.createInvoice(createdSubscription);
        } catch (RazorpayException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create subscription: " + e.getMessage());
        }
    }
    
    @PostMapping("/verify_payment")
    public ResponseEntity<String> verifyAndSavePayment(@RequestBody Map<String, String> requestBody) throws NoSuchAlgorithmException, RazorpayException {
		
		  if (verifySignature(requestBody.get("razorpay_subscription_id"), requestBody.get("razorpay_payment_id"), requestBody.get("razorpay_signature"), apiSecret )) {
			  
			  return ResponseEntity.ok("Payment verification and data save successful");
		  }
		  else {
			  return ResponseEntity
				    .status(HttpStatus.INTERNAL_SERVER_ERROR)
				    .body("Internal server error: Payment verification failed.");
		  }

		
    }
	
	public static boolean verifySignature(String razorpay_subscription_id, String razorpay_payment_id, String razorpay_signature, String secret) throws RazorpayException, NoSuchAlgorithmException {
		JSONObject options = new JSONObject();
		options.put("razorpay_subscription_id", razorpay_subscription_id);
		options.put("razorpay_payment_id", razorpay_payment_id);
		options.put("razorpay_signature", razorpay_signature);

		boolean status =  Utils.verifySubscription(options, secret);
		return status;
    }

}
