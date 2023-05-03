package com.live_glow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.live_glow.model.Cart;
import com.live_glow.model.Product;
import com.live_glow.util.DBConnection;

public class cartDao implements CartList<Cart>{
	Cart cart=new Cart();
	
	public boolean addToCart(int productId,int personId,int quantity) throws SQLException {
		boolean response = false;
		final Connection conn = DBConnection.getConnection();
		try {
			String query= "INSERT INTO CART (PRODUCT_ID, PERSON_ID, QUANTITY) VALUES (?, ?, ?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setLong(1,productId );
			pst.setLong(2,personId);
			pst.setLong(3,quantity);
			response = pst.execute();
			pst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	
	
	public List<Cart> getCartProducts(ArrayList<Cart> cart_list) throws SQLException{
		final Connection conn=DBConnection.getConnection();
		List<Cart> products = new ArrayList<>();
		try {
			if(cart_list.size()>0) {
				for(Cart item:cart_list) {
					String query="SELECT * FROM PRODUCTS WHERE PRODUCT_ID=?";
					PreparedStatement statement=conn.prepareStatement(query);
					statement.setInt(1, item.getProduct().getProductId());
					final ResultSet rs= statement.executeQuery();
					while(rs.next()) {
						Cart cart=new Cart();
						cart.setProductId(rs.getInt("PRODUCT_ID"));
						cart.setImage_url(rs.getString("IMAGE_URL"));
						cart.setProductName(rs.getString("PRODUCT_NAME"));
						cart.setPrice(rs.getDouble("PRICE")*item.getQuantity());
						cart.setQuantity(item.getQuantity());
						products.add(cart);
					}
				}
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		return products;
	}
	
	public List<Cart> getCartItemByUserId(int personId) throws SQLException{
		final Connection conn=DBConnection.getConnection();
		List<Cart> products = new ArrayList<>();
		try {
			String query="SELECT * FROM CART WHERE PERSON_ID=?";
			PreparedStatement statement=conn.prepareStatement(query);
			statement.setInt(1, personId);
			final ResultSet rs= statement.executeQuery();
			while(rs.next()) {
				Cart cart=new Cart();
				ProductDao productdao = new ProductDao();
				Product product = productdao.getProductById(rs.getInt("PRODUCT_ID"));
				cart.setProduct(product);
				cart.setProductId(product.getProductId());
				cart.setImage_url(product.getImage_url());
				cart.setProductName(product.getProductName());
				cart.setPrice(product.getPrice()*rs.getInt("QUANTITY"));
				cart.setQuantity(rs.getInt("QUANTITY"));
				products.add(cart);
			}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		return products;
		}
	
	public boolean updateQuantity(int personId,int productId,int quantity) throws SQLException {
		boolean response = false;
		final Connection conn=DBConnection.getConnection();
		try {
			String query="UPDATE CART SET QUANTITY = ? WHERE PERSON_ID = ? AND PRODUCT_ID = ?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, quantity);
			pst.setInt(2, personId);
			pst.setInt(3, productId);
			response = pst.execute();
			pst.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;	
	}

	
	public double getTotalCartPrice(List<Cart> cart_list) {
		double sum=0;
		try {
			for(Cart item: cart_list) {
				sum+=item.getPrice();
			}
			System.out.println(sum);
		}catch(Exception e){
			e.printStackTrace();
		}
		return sum;
	}
	
	public boolean removeProduct(int personId,int productId) throws SQLException {
		boolean response = false;
		final Connection conn = DBConnection.getConnection();
		try {
			String query="DELETE FROM CART WHERE PERSON_ID = ? AND PRODUCT_ID = ?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, personId);
			pst.setInt(2, productId);
			response = pst.execute();
			pst.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;	
	}
	
	public boolean removeCartProducts(int personId,List<Cart> cart_list) throws SQLException {
		boolean response = false;
		for(Cart item:cart_list) {
			removeProduct(personId, item.getProductId());
		}
		return response;
	}
}