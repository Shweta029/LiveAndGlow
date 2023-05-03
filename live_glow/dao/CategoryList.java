package com.live_glow.dao;

import java.sql.SQLException;
import java.util.List;

public interface CategoryList<T> {
	
	
	List<T> getAllCategorys() throws SQLException;
	T getCategoryById(int CategoryId);
	T getCategoryByName(String CategoryName);
	
	Boolean updateCategory(int id, T t);
	

}
