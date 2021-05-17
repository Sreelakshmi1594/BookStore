package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="checkout_cart")
public class CheckoutCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long checkout_id;
	
	@Column(name= "order_id")
	String order_id;
	
	@Column(name= "payment_type")
	String payment_type;
	
	@Column(name= "delivery_addres")
	String delivery_address;
	
	@Column(name= "user_id")
	long user_id;
	
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "product_id")
	Products product;	
	
	@Column(name= "qty")
	int qty;
	
	@Column(name= "price")
	double price;
	
	@Column(name= "order_date")
	String order_date;
	
	
	
	public long getCheckout_id() {
		return checkout_id;
	}
	public void setCheckout_id(long checkout_id) {
		this.checkout_id = checkout_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public String getDelivery_address() {
		return delivery_address;
	}
	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	
	
}