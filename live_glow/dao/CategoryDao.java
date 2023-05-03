package com.live_glow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.live_glow.model.Category;
import com.live_glow.model.Category;
import com.live_glow.util.DBConnection;

public class CategoryDao implements CategoryList<Category> {

	@Override
	public List<Category> getAllCategorys() throws SQLException {

		List<Category> categoryList = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			final Connection connection = DBConnection.getConnection();
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery("SELECT CATEGORY_ID, CATEGORY_NAME  FROM CATEGORIES");
			while (resultSet.next()) {
				Category category = new Category(resultSet.getInt("CATEGORY_ID"), resultSet.getString("CATEGORY_NAME"));

				categoryList.add(category);

			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return categoryList;
	}

	@Override
	public Category getCategoryById(int CategoryId) {
		Category category = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			final Connection connection = DBConnection.getConnection();
			final String select = "SELECT CATEGORY_ID, CATEGORY_NAME  FROM CATEGORIES WHERE CATEGORY_ID = ? ";
			final PreparedStatement preparedStatement = connection.prepareStatement(select);
			final ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				category = new Category(resultSet.getInt("CATEGORY_ID"), resultSet.getString("CATEGORY_NAME"));

			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return category;
	}

	@Override
	public Category getCategoryByName(String CategoryName) {
	      
		Category category = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			final Connection connection = DBConnection.getConnection();
			final String select = "SELECT CATEGORY_ID, CATEGORY_NAME  FROM CATEGORIES WHERE CATEGORY_NAME = ? ";
			final PreparedStatement preparedStatement = connection.prepareStatement(select);
			final ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				category = new Category(resultSet.getInt("CATEGORY_ID"), resultSet.getString("CATEGORY_NAME"));

			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return category;

	}

	@Override
	public Boolean updateCategory(int id, Category t) {
	
		Connection connection;
		try {
			connection = DBConnection.getConnection();
		
		final String updateRecord = "update CATEGORIES set "
				+" CATEGORY_NAME=?"
				
				+" where CATEGORY_ID=?";
		final PreparedStatement preparedStatement = connection.prepareStatement(updateRecord);
		preparedStatement.setString(1,t.getCategoryName() );
	
		if (preparedStatement.executeUpdate() > 0) {
			return true;
		}
		preparedStatement.close();
		connection.close();
		} catch (SQLException e) {
		     e.printStackTrace();
		}
		return false;
	}

}
