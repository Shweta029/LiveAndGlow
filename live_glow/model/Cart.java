package com.live_glow.model;

public class Cart {
	private static int cartId;
	
	
	
	/*
	 * public Cart(int quantity, int productId) { super(); cartId++; this.quantity =
	 * quantity; this.productId = productId; }
	 * 
	 * public Cart(int cartId, int quantity, int productId) { super(); this.cartId =
	 * cartId; this.quantity = quantity; this.productId = productId; }
	 * 
	 * public int getCartId() { return cartId; }
	 * 
	 * public void setCartId(int cartId) { this.cartId = cartId; }
	 */
	private int quantity  = 0;
	private Product product;
	private int productId;
	private String image_url;
	private String productName;
	private double price;

	public Cart() {
		super();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [quantity=" + quantity + ", product=" + product + ", productId=" + productId + ", image_url="
				+ image_url + ", productName=" + productName + ", price=" + price + "]";
	}
	
	
	public Cart(int productId, String image_url,String productName, Double price ) {
		super();
		this.productId=product.getProductId();
		this.image_url=product.getImage_url();
		this.productName=product.getProductName();
		this.price=product.getPrice();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

	
	

	
	
	
		
}
