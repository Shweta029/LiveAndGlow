package com.live_glow.model;

import java.util.Date;

public class Order {
	private int orderId;
	private int quantity;
	private Person person;
	private Product product;
	private Date orderDate;
	private int PersonId;
	private int productId;
	private String paymentType;
	private String personName;
	private String email;
	private long contactNo;
	private String address;
	private double price;
	
	
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Order(int orderId, int quantity, Person person, Product product, Date orderDate, int personId, int productId,
			String paymentType, String personName, String email, long contactNo, String address, double price) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.person = person;
		this.product = product;
		this.orderDate = orderDate;
		PersonId = personId;
		this.productId = productId;
		this.paymentType = paymentType;
		this.personName = personName;
		this.email = email;
		this.contactNo = contactNo;
		this.address = address;
		this.price = price;
	}

	public Order() {
		super();	
		}

	public Order(int orderId, Person person, Product product, Date orderDate,int quantity) {
		super();
		this.orderId = orderId;
		this.person = person;
		this.product = product;
		this.orderDate = orderDate;
		this.quantity=quantity;
	}
	public Order(int orderId, int PersonId, int productId,int quantity,Date orderDate) {
		super();
		this.orderId = orderId;
		this.PersonId = person.getPersonId();
		this.productId = product.getProductId();
		this.quantity=quantity;
		this.orderDate = orderDate;
	}
	

	public Order(int PersonId, int quantity ,Date orderDate) {
		super();
		this.PersonId = person.getPersonId();
		this.quantity = quantity;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public java.util.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date date) {
		this.orderDate = date;
	}

	public int getPersonId() {
		return PersonId;
	}

	public void setPersonId(int personId) {
		this.PersonId = personId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", quantity=" + quantity + ", person=" + person + ", product=" + product
				+ ", orderDate=" + orderDate + ", PersonId=" + PersonId + ", productId=" + productId + ", paymentType="
				+ paymentType + ", personName=" + personName + ", email=" + email + ", contactNo=" + contactNo
				+ ", address=" + address + ", price=" + price + "]";
	}
	
}
