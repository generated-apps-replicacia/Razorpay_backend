package com.apps.petcare.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



import com.apps.petcare.model.Pet;
import com.apps.petcare.model.PetCareCenter;
import com.apps.petcare.model.PetOwner;
import com.apps.petcare.model.Document;
import com.apps.petcare.model.PetService;
import com.apps.petcare.enums.PetServiceType;
import com.apps.petcare.converter.PetServiceTypeConverter;
import com.apps.petcare.converter.DurationConverter;
import com.apps.petcare.converter.UUIDToByteConverter;
import com.apps.petcare.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "PaymentDetails")
@Table(name = "\"PaymentDetails\"", schema =  "\"petcare\"")
@Data
public class PaymentDetails {
        public PaymentDetails () {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"PaymentId\"", nullable = true )
  private Integer paymentId;

  @Column(name = "\"RazorpayOrderId\"", nullable = true )
  private String razorpayOrderId;


  @Column(name = "\"RazorpayPaymentId\"", nullable = true )
  private String razorpayPaymentId;


  @Column(name = "\"RazorpaySignature\"", nullable = true )
  private String razorpaySignature;
  
  @Column(name = "\"OrderId\"", nullable = true )
  private String orderId;


  public Integer getPaymentId() {
	return paymentId;
}


public void setPaymentId(Integer paymentId) {
	this.paymentId = paymentId;
}


public String getRazorpayOrderId() {
	return razorpayOrderId;
}


public void setRazorpayOrderId(String razorpayOrderId) {
	this.razorpayOrderId = razorpayOrderId;
}


public String getRazorpayPaymentId() {
	return razorpayPaymentId;
}


public void setRazorpayPaymentId(String razorpayPaymentId) {
	this.razorpayPaymentId = razorpayPaymentId;
}


public String getRazorpaySignature() {
	return razorpaySignature;
}


public void setRazorpaySignature(String razorpaySignature) {
	this.razorpaySignature = razorpaySignature;
}


public String getOrderId() {
	return orderId;
}


public void setOrderId(String orderId) {
	this.orderId = orderId;
}


@Override
  public String toString() {
        return "PaymentDetails ["
  + "PaymentId= " + paymentId  + ", "
  + "RazorpayOrderId= " + razorpayOrderId  + ", "
  + "RazorpayPaymentId= " + razorpayPaymentId  + ", "
  + "RazorpaySignature= " + razorpaySignature  + "]";
  }

}
