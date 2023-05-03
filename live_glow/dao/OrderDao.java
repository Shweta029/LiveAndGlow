package com.live_glow.dao;
import com.live_glow.model.*;
import com.live_glow.dao.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.live_glow.model.Order;
import com.live_glow.util.DBConnection;

public class OrderDao {
	public boolean insertOrder(NewOrder order) {
		boolean result=false;
		try {
			Connection conn = DBConnection.getConnection();
			String query= "INSERT INTO ORDERS(PERSON_ID,PRODUCT_ID,QUANTITY,PAYMENT_TYPE,ORDER_STATUS) "
					+ "VALUES(?,?,?,?,'Ordered')";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, order.getPersonId());
			statement.setInt(2, order.getProductId());
			statement.setInt(3, order.getQuantity());
			statement.setString(4, order.getPaymentType());
			
			statement.executeUpdate();
			result=true;
			
			statement.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
		
	}
	
	public List<Order> personOrders(int personId){
		List<Order> orderlist = new ArrayList<>();
		try {
			Connection conn = DBConnection.getConnection();
			String query = "SELECT * FROM ORDERS WHERE PERSON_ID=? ORDER BY ORDER_ID DESC";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, personId);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Order order = new Order();
				ProductDao productDao = new ProductDao();
				int productId = rs.getInt("PRODUCT_ID");
				/* Product product1= new Product(); */
				Product product = productDao.getProductById(productId);
				
				order.setOrderId(rs.getInt("ORDER_ID"));
				order.setProduct(product);
				System.out.println(product);
				order.setQuantity(rs.getInt("QUANTITY"));
				order.setOrderDate(rs.getDate("ORDER_DATE"));
				orderlist.add(order);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return orderlist;
	}
	
	public void cancelOrder(int orderId) {
		try {
			final Connection conn=DBConnection.getConnection();
			String query="DELETE FROM ORDERS WHERE ORDER_ID=?";
			PreparedStatement statement= conn.prepareStatement(query);
			statement.setInt(1, orderId);
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean allOrder(List<Order> o) {
		boolean result= false;
		try {
			final Connection conn = DBConnection.getConnection();
			String query = "INSERT INTO ORDERS(ORDER_ID,PERSON_ID,PAYMENT_TYPE) VALUES(?,?,?)";
			conn.setAutoCommit(false);
			PreparedStatement statement= conn.prepareStatement(query);
			
			for(Order order: o) {
				statement.setInt(1, order.getOrderId());
				statement.setInt(2, order.getPersonId());
				statement.setString(3, order.getPaymentType());
				statement.addBatch();
			}
			
			  int[] count =statement.executeBatch();
			 			result =true;
			conn.setAutoCommit(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public List<Order> getAllOrders(){
		System.out.println("Hey I got Called PersonOrders");
		List<Order> orderlist = new ArrayList<>();
		try {
			Connection conn = DBConnection.getConnection();
			String query = "SELECT * FROM ORDERS ORDER BY ORDER_ID DESC";
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Order order = new Order();
				ProductDao productDao = new ProductDao();
				int productId = rs.getInt("PRODUCT_ID");
				/* Product product1= new Product(); */
				Product product = productDao.getProductById(productId);
				
				order.setOrderId(rs.getInt("ORDER_ID"));
				order.setProduct(product);
				System.out.println(product);
				order.setQuantity(rs.getInt("QUANTITY"));
				order.setOrderDate(rs.getDate("ORDER_DATE"));
				order.setPaymentType(rs.getString("PAYMENT_TYPE"));
				Person_Dao personDao= new Person_Dao();
				Person person = personDao.getPersonById(rs.getInt("PERSON_ID"));
				order.setPerson(person);
				orderlist.add(order);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(orderlist);
		return orderlist;
	}
	
}
