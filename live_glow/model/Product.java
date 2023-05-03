package com.live_glow.model;


 
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class Product  {
//	 private static final long serialVersionUID = 1L;
	
	private int productId;
	private String productName;
	private String productSize;
	private String key_ingredients;
	private String skinType;
	private String benefit;
	private int quantity;
	private double  price;
	private Set<Review> Reviews;
	private double rating;
	private String image_url;
	private int categoryId;
	private Category category;
	private String brandName;
	private String categoryName;
	
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getKey_ingredients() {
		return key_ingredients;
	}
	public void setKey_ingredients(String key_ingredients) {
		this.key_ingredients = key_ingredients;
	}
	public String getSkinType() {
		return skinType;
	}
	public void setSkinType(String skinType) {
		this.skinType = skinType;
	}
	public String getBenefit() {
		return benefit;
	}
	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Set<Review> getReviews() {
		return Reviews;
	}
	public void setReviews(Set<Review> reviews) {
		Reviews = reviews;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Product(int productId, String productName, String productSize, String key_ingredients, String skinType,
			String benefit, int quantity, double price, Set<Review> reviews, double rating, String image_url,
			Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productSize = productSize;
		this.key_ingredients = key_ingredients;
		this.skinType = skinType;
		this.benefit = benefit;
		this.quantity = quantity;
		this.price = price;
//		Reviews = reviews;
		this.rating = rating;
		this.image_url = image_url;
		this.category = category;
	}
	
	public Product(int productId, String productName, String productSize, String key_ingredients, String skinType,
			String benefit, int quantity, double price, Set<Review> reviews, double rating, String image_url,
			String categoryName) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productSize = productSize;
		this.key_ingredients = key_ingredients;
		this.skinType = skinType;
		this.benefit = benefit;
		this.quantity = quantity;
		this.price = price;
//		Reviews = reviews;
		this.rating = rating;
		this.image_url = image_url;
		this.categoryName = category.getCategoryName();
	}
	
	
	public Product(int productId, String productName, String productSize, String key_ingredients, String skinType,
			String benefit, int i, double d ,double rating, String image_url,
			int categoryId, String brandName) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productSize = productSize;
		this.key_ingredients = key_ingredients;
		this.skinType = skinType;
		this.benefit = benefit;
		this.quantity = i;
		this.price = d;
		this.rating = rating;
		this.image_url = image_url;
		this.categoryId = categoryId;
		this.brandName = brandName;
	}
	
	public Product(int productId, String productName, String productSize, String key_ingredients, String skinType,
			String benefit, int quantity, double price ,double rating, String image_url,
			int categoryId, String categoryName, String brandName) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productSize = productSize;
		this.key_ingredients = key_ingredients;
		this.skinType = skinType;
		this.benefit = benefit;
		this.quantity = quantity;
		this.price = price;
		this.rating = rating;
		this.image_url = image_url;
		this.categoryId = categoryId;
		this.categoryName= category.getCategoryName();
		this.brandName = brandName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(productId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return productId == other.productId;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productSize=" + productSize
				+ ", key_ingredients=" + key_ingredients + ", skinType=" + skinType + ", benefit=" + benefit
				+ ", quantity=" + quantity + ", price=" + price + ", Reviews=" + Reviews + ", rating=" + rating
				+ ", image_url=" + image_url + ", categoryId=" + categoryId + ", category=" + category + ", brandName="
				+ brandName + "]";
	}
	
	
	

}
