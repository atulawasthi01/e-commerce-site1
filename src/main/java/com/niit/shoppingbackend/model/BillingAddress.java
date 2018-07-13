package com.niit.shoppingbackend.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Entity
@Component
public class BillingAddress {

	@Id
	@GenericGenerator(name = "billingAddress", strategy = "increment")
	@GeneratedValue(generator = "billingAddress")
	private int billingId;
	private String billingCity;
	private String billingLocality;
	private String billingPincode;
	private String billingState;
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	Customer customer;
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	ShippingAddress shippingAddress;
	
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public int getBillingId() {
		return billingId;
	}
	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}
	public String getBillingCity() {
		return billingCity;
	}
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}
	public String getBillingLocality() {
		return billingLocality;
	}
	public void setBillingLocality(String billingLocality) {
		this.billingLocality = billingLocality;
	}
	public String getBillingPincode() {
		return billingPincode;
	}
	public void setBillingPincode(String billingPincode) {
		this.billingPincode = billingPincode;
	}
	public String getBillingState() {
		return billingState;
	}
	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
