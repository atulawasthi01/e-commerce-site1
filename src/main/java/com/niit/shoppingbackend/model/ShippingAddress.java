package com.niit.shoppingbackend.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
public class ShippingAddress {

	@Id
	@GenericGenerator(name = "shippingAddress", strategy = "increment")
	@GeneratedValue(generator = "shippingAddress")
	private int shippingId;
	private String shippingCity;
	private String shippingLocality;
	private String shippingPincode;
	private String shippingState;
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	Customer customer;
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	BillingAddress billingAddress;
	
	
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getShippingId() {
		return shippingId;
	}
	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}
	public String getShippingCity() {
		return shippingCity;
	}
	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}
	
	public String getShippingLocality() {
		return shippingLocality;
	}
	public void setShippingLocality(String shippingLocality) {
		this.shippingLocality = shippingLocality;
	}
	public String getShippingPincode() {
		return shippingPincode;
	}
	public void setShippingPincode(String shippingPincode) {
		this.shippingPincode = shippingPincode;
	}
	public String getShippingState() {
		return shippingState;
	}
	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}
}
