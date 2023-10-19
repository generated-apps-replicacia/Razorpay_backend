package com.apps.petcare.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.UUID;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apps.petcare.model.PaymentDetails;
import com.apps.petcare.repository.PaymentDetailsRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("PetCareBENag/payment")
public class PaymentController {
	
	@Autowired
	private PaymentDetailsRepository paymentDetailsRepository;

	@Value("${razorpay.api.key}")
	String apiKey;
	
	@Value("${razorpay.api.secret}")
	String apiSecret;
	
	@PostMapping("/create_order")
	@ResponseBody
	public ResponseEntity<String> createOrder() {
		System.out.println("Order Creation Started");
		int amount = 100;
		System.out.println("API Key: "+ apiKey);
		System.out.println("API Secret: "+ apiSecret);
		try {
			RazorpayClient client = new RazorpayClient(apiKey, apiSecret);
			JSONObject ob = new JSONObject();
			ob.put("amount", amount);
			ob.put("currency", "INR");
			ob.put("receipt", generateReceiptNumber());
			
			Order order = client.orders.create(ob); //we can save this in DB
			
			System.out.println("order: " + order);
			return ResponseEntity
	                .ok()
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(order.toString());
		} catch (RazorpayException e) {
			e.printStackTrace();
			return ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("{\"error\": \"An error occurred.\"}");
		}
	}
	
	@PostMapping("/verify_payment")
    public ResponseEntity<String> verifyAndSavePayment(@RequestBody Map<String, String> requestBody) throws NoSuchAlgorithmException, RazorpayException {
		
		  if (verifySignature(requestBody.get("razorpay_order_id"), requestBody.get("razorpay_payment_id"), requestBody.get("razorpay_signature"), apiSecret )) {		    

			  PaymentDetails paymentDetails = new PaymentDetails();
			  
			  paymentDetails.setRazorpayOrderId(requestBody.get("razorpay_order_id"));
			  paymentDetails.setOrderId(requestBody.get("order_id"));
			  paymentDetails.setRazorpayPaymentId(requestBody.get("razorpay_payment_id"));
			  paymentDetails.setRazorpaySignature(requestBody.get("razorpay_signature"));
			  
			  paymentDetailsRepository.save(paymentDetails);
			  
			  return ResponseEntity.ok("Payment verification and data save successful");
		  }
		  else {
			  return ResponseEntity
				    .status(HttpStatus.INTERNAL_SERVER_ERROR)
				    .body("Internal server error: Payment verification failed.");
		  }

		
    }
	
	public static boolean verifySignature(String razorpay_order_id, String razorpay_payment_id, String razorpay_signature, String secret) throws RazorpayException, NoSuchAlgorithmException {
		JSONObject options = new JSONObject();
		options.put("razorpay_order_id", razorpay_order_id);
		options.put("razorpay_payment_id", razorpay_payment_id);
		options.put("razorpay_signature", razorpay_signature+"K");

		boolean status =  Utils.verifyPaymentSignature(options, secret);
		return status;
    }
	
	public static String generateReceiptNumber() {
        String prefix = "RECEIPT";  // prefix
        String timestamp = String.valueOf(System.currentTimeMillis());
        String randomPart = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);  // 10 characters from a UUID

        // Ensure the total length is not greater than 40 characters
        int maxLength = 40 - prefix.length();
        int availableLength = maxLength - timestamp.length();
        if (availableLength < randomPart.length()) {
            randomPart = randomPart.substring(0, availableLength);
        }

        return prefix + "_" + timestamp + "_" + randomPart;
    }
}
