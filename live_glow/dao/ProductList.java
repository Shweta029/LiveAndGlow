package com.live_glow.dao;

import java.sql.SQLException;
import java.util.List;

public interface ProductList<T> {
	
	
	List<T> getAllProducts() throws SQLException;
	
	List<T> getAllProductsByCategory(int id) throws SQLException;
	
	T getProductById(int ProductId)throws SQLException;
	List<T> getProductByName(String productName)throws SQLException;
	List<T> getProductByBrand(String brandName)throws SQLException;
	Boolean updateProduct(int id, T t)throws SQLException;
	Boolean createProduct(T product)throws SQLException;
	List<T> sortProductByName() throws SQLException;
	List<T> sortProductByBrand() throws SQLException;
	List<T> filterProductByCatogory()throws SQLException;
	List<T> filterProductByPriceLowToHigh()throws SQLException;
	List<T> filterProductByPriceHighToLow()throws SQLException;
	
	
	
	
	

}