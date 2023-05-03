/*
 * package com.live_glow.dao;
 * 
 * import java.sql.Connection; import java.sql.PreparedStatement; import
 * java.sql.ResultSet; import java.sql.SQLException; import
 * java.sql.SQLIntegrityConstraintViolationException; import java.sql.Statement;
 * import java.util.ArrayList; import java.util.Comparator; import
 * java.util.List; import com.live_glow.dao.ProductList;
 * 
 * import com.live_glow.model.Product; import com.live_glow.util.DBConnection;
 * 
 * public class ProductDao implements ProductList<Product> {
 * 
 * private ProductDao productDao;
 * 
 * public ProductDao() { super();
 * 
 * }
 * 
 * public ProductDao getProductDao() {
 * 
 * if (productDao == null) { synchronized (ProductDao.class) { if (productDao ==
 * null) { productDao = new ProductDao(); }
 * 
 * } } return productDao; }
 * 
 * 
 * 
 * @Override public Boolean createProduct(Product product) {
 * 
 * 
 * 
 * return false; }
 * 
 * @Override public List<Product> getAllProducts() {
 * 
 * List<Product> productList = new ArrayList<>(); try {
 * Class.forName("oracle.jdbc.driver.OracleDriver"); final Connection connection
 * = DBConnection.getConnection(); final PreparedStatement statement =
 * connection.
 * prepareStatement("SELECT PRODUCT_ID, PRODUCT_NAME,PRODUCT_SIZE,KEY_INGREDIENTS, SKIN_TYPE,BENEFIT, QUANTITY, PRICE, RATING, IMAGE_URL, CATEGORY_ID, BRAND_NAME  FROM PRODUCTS "
 * ); final ResultSet resultSet = statement.executeQuery(); while
 * (resultSet.next()) { Product product = new Product();
 * product.setProductId(resultSet.getInt("PRODUCT_ID"));
 * product.setProductName(resultSet.getString("PRODUCT_NAME"));
 * product.setProductSize(resultSet.getString("PRODUCT_SIZE"));
 * product.setKey_ingredients(resultSet.getString("KEY_INGREDIENTS"));
 * product.setSkinType(resultSet.getString("SKIN_TYPE"));
 * product.setBenefit(resultSet.getString("BENEFIT"));
 * product.setQuantity(resultSet.getInt("QUANTITY"));
 * product.setPrice(resultSet.getDouble("PRICE"));
 * product.setRating(resultSet.getDouble("RATING"));
 * product.setImage_url(resultSet.getString("IMAGE_URL"));
 * product.setCategoryId(resultSet.getInt("CATEGORY_ID"));
 * product.setBrandName(resultSet.getString("BRAND_NAME"));
 * 
 * productList.add(product); } resultSet.close(); statement.close();
 * connection.close(); } catch (ClassNotFoundException e) {
 * 
 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
 * block e.printStackTrace(); }
 * 
 * return productList; }
 * 
 * @Override public Product getProductById(int productId) { Product product =
 * null; try { final String select =
 * "SELECT PRODUCT_ID, PRODUCT_NAME,PRODUCT_SIZE,KEY_INGREDIENTS, SKIN_TYPE,BENEFIT, QUANTITY, PRICE, RATING, IMAGE_URL, CATEGORY_ID, BRAND_NAME  FROM PRODUCTS "
 * + "WHERE PRODUCT_ID = ?"; Class.forName("oracle.jdbc.driver.OracleDriver");
 * 
 * final Connection connection = DBConnection.getConnection(); final
 * PreparedStatement preparedStatement = connection.prepareStatement(select);
 * preparedStatement.setInt(1, productId); final ResultSet resultSet =
 * preparedStatement.executeQuery();
 * 
 * while (resultSet.next()) { product = new
 * Product(resultSet.getInt("PRODUCT_ID"), resultSet.getString("PRODUCT_NAME"),
 * resultSet.getString("PRODUCT_SIZE"), resultSet.getString("KEY_INGREDIENTS"),
 * resultSet.getString("SKIN_TYPE"), resultSet.getString("BENEFIT"),
 * resultSet.getInt("QUANTITY"), resultSet.getDouble("PRICE"),
 * resultSet.getDouble("RATING"), resultSet.getString("IMAGE_URL"),
 * resultSet.getInt("CATEGORY_ID"), resultSet.getString("BRAND_NAME")
 * 
 * );
 * 
 * } resultSet.close(); preparedStatement.close(); connection.close();
 * 
 * } catch (ClassNotFoundException e) {
 * 
 * e.printStackTrace(); } catch (SQLException e) {
 * 
 * e.printStackTrace(); } return product;
 * 
 * }
 * 
 * @Override public Product getProductByName(String productName) {
 * 
 * Product product = null; try { final String select =
 * "SELECT PRODUCT_ID, PRODUCT_NAME,PRODUCT_SIZE,KEY_INGREDIENTS, SKIN_TYPE,BENEFIT, QUANTITY, PRICE, RATING, IMAGE_URL, CATEGORY_ID, BRAND_NAME  FROM PRODUCTS "
 * + "WHERE PRODUCT_NAME = ?"; Class.forName("oracle.jdbc.driver.OracleDriver");
 * 
 * final Connection connection = DBConnection.getConnection(); final
 * PreparedStatement preparedStatement = connection.prepareStatement(select);
 * preparedStatement.setString(1, productName); final ResultSet resultSet =
 * preparedStatement.executeQuery();
 * 
 * if (resultSet.next()) { product = new Product(resultSet.getInt("PRODUCT_ID"),
 * resultSet.getString("PRODUCT_NAME"), resultSet.getString("PRODUCT_SIZE"),
 * resultSet.getString("KEY_INGREDIENTS"), resultSet.getString("SKIN_TYPE"),
 * resultSet.getString("BENEFIT"), resultSet.getInt("QUANTITY"),
 * resultSet.getDouble("PRICE"), resultSet.getDouble("RATING"),
 * resultSet.getString("IMAGE_URL"), resultSet.getInt("CATEGORY_ID"),
 * resultSet.getString("BRAND_NAME")
 * 
 * );
 * 
 * } resultSet.close(); preparedStatement.close(); connection.close();
 * 
 * } catch (ClassNotFoundException e) {
 * 
 * e.printStackTrace(); } catch (SQLException e) {
 * 
 * e.printStackTrace(); } return product; }
 * 
 * @Override public Product getProductByBrand(String brandName) {
 * 
 * Product product = null; try { final String select =
 * "SELECT PRODUCT_ID, PRODUCT_NAME,PRODUCT_SIZE,KEY_INGREDIENTS, SKIN_TYPE,BENEFIT, QUANTITY, PRICE, RATING, IMAGE_URL, CATEGORY_ID, BRAND_NAME  FROM PRODUCTS "
 * + "WHERE BRAND_NAME = ?";
 * 
 * Class.forName("oracle.jdbc.driver.OracleDriver");
 * 
 * final Connection connection = DBConnection.getConnection(); final
 * PreparedStatement preparedStatement = connection.prepareStatement(select);
 * preparedStatement.setString(1, brandName.toString()); final ResultSet
 * resultSet = preparedStatement.executeQuery();
 * 
 * if (resultSet.next()) { product = new Product(resultSet.getInt("PRODUCT_ID"),
 * resultSet.getString("PRODUCT_NAME"), resultSet.getString("PRODUCT_SIZE"),
 * resultSet.getString("KEY_INGREDIENTS"), resultSet.getString("SKIN_TYPE"),
 * resultSet.getString("BENEFIT"), resultSet.getInt("QUANTITY"),
 * resultSet.getDouble("PRICE"), resultSet.getDouble("RATING"),
 * resultSet.getString("IMAGE_URL"), resultSet.getInt("CATEGORY_ID"),
 * resultSet.getString("BRAND_NAME")
 * 
 * );
 * 
 * } resultSet.close(); preparedStatement.close(); connection.close();
 * 
 * } catch (ClassNotFoundException e) {
 * 
 * e.printStackTrace(); } catch (SQLException e) {
 * 
 * e.printStackTrace(); } return product; }
 * 
 * @Override public Boolean updateProduct(int id, Product product) {
 * 
 * try { // final String select =
 * "SELECT PRODUCT_ID, PRODUCT_NAME,PRODUCT_SIZE,KEY_INGREDIENTS, SKIN_TYPE,BENEFIT, QUANTITY, PRICE, RATING, IMAGE_URL, CATEGORY_ID, BRAND_NAME  FROM PRODUCTS "
 * // + "WHERE BRAND_NAME = ?";
 * 
 * Class.forName("oracle.jdbc.driver.OracleDriver");
 * 
 * final Connection connection = DBConnection.getConnection();
 * 
 * final String updateRecord = "update Products set " + " QUANTITY=?," +
 * " PRICE=?," + "IMAGE_URL =?,"
 * 
 * + " where  PRODUCT_ID =?";
 * 
 * final PreparedStatement preparedStatement =
 * connection.prepareStatement(updateRecord); preparedStatement.setInt(1,
 * product.getQuantity()); preparedStatement.setDouble(2, product.getPrice());
 * preparedStatement.setString(3, product.getImage_url()); if
 * (preparedStatement.executeUpdate() > 0) { return true; }
 * 
 * preparedStatement.close(); connection.close();
 * 
 * } catch (ClassNotFoundException e) {
 * 
 * e.printStackTrace(); } catch (SQLException e) {
 * 
 * e.printStackTrace(); } return false;
 * 
 * }
 * 
 * @Override public List<Product> sortProductByName() throws SQLException {
 * List<Product> productList = new ArrayList<>();
 * 
 * ProductDao productDa = new ProductDao(); Comparator<Product> products =
 * (product1, product2) -> product2.getProductName()
 * .compareTo(product1.getProductName()); productList =
 * productDa.getAllProducts().stream().sorted(products).toList(); return
 * productList; }
 * 
 * @Override public List<Product> sortProductByBrand() throws SQLException {
 * 
 * List<Product> productList = new ArrayList<>();
 * 
 * ProductDao productDa = new ProductDao(); Comparator<Product> products =
 * (product1, product2) -> product2.getBrandName()
 * .compareTo(product1.getBrandName()); productList =
 * productDa.getAllProducts().stream().sorted(products).toList(); return
 * productList; }
 * 
 * @Override public List<Product> filterProductByCatogory() {
 * 
 * return null; }
 * 
 * public Product Add_Products(Product product) { boolean result=false;
 * 
 * 
 * try { String
 * insert="INSERT INTO PRODUCTS(PRODUCT_ID,PRODUCT_NAME,PRODUCT_SIZE,KEY_INGREDIENTS,SKIN_TYPE,BENEFIT, QUANTITY, PRICE,IMAGE_URL, CATEGORY_ID, BRAND_NAME)"
 * ; Class.forName("oracle.jdbc.driver.OracleDriver");
 * 
 * final Connection connection = DBConnection.getConnection(); final
 * PreparedStatement preparedStatement = connection.prepareStatement(insert);
 * preparedStatement.setInt(1, 4);
 * preparedStatement.setString(2,product.getProductName());
 * preparedStatement.setString(3,product.getProductSize());
 * preparedStatement.setString(4,product.getKey_ingredients());
 * preparedStatement.setString(5,product.getSkinType());
 * preparedStatement.setString(6,product.getBenefit());
 * preparedStatement.setInt(7,product.getQuantity());
 * preparedStatement.setDouble(8,product.getPrice());
 * preparedStatement.setString(9,product.getImage_url());
 * 
 * preparedStatement.setString(10,product.getCategory().getCategoryName());
 * preparedStatement.setString(11,product.getBrandName()); final int noOrRows =
 * preparedStatement.executeUpdate(); if (noOrRows > 0) { return product; }
 * result=true; connection.setAutoCommit(true);
 * 
 * preparedStatement.close(); connection.close(); throw new
 * SQLIntegrityConstraintViolationException("Duplicate Primary key");
 * 
 * } catch (SQLException | ClassNotFoundException e) { } return product;
 * 
 * 
 * }
 * 
 * 
 * }
 * 
 * 
 */

package com.live_glow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.live_glow.dao.ProductList;

import com.live_glow.model.Product;
import com.live_glow.util.DBConnection;

public class ProductDao implements ProductList<Product> {

	private ProductDao productDao;

	public ProductDao() {

		super();

	}

	public ProductDao getProductDao() {

		if (productDao == null) {
			synchronized (ProductDao.class) {
				if (productDao == null) {
					productDao = new ProductDao();
				}

			}
		}
		return productDao;
	}

	@Override
	public Boolean createProduct(Product product) {

		return false;
	}
	
	
	public Product Add_Products(Product product) {
		
		   
		
		try {
			String insert="INSERT INTO PRODUCTS(PRODUCT_ID,PRODUCT_NAME,PRODUCT_SIZE,KEY_INGREDIENTS,SKIN_TYPE,BENEFIT, QUANTITY, PRICE,IMAGE_URL, CATEGORY_ID, BRAND_NAME) values(PRODUCT_1.nextval,?,?,?,?,?,?,?,?,?,?)";
			Class.forName("oracle.jdbc.driver.OracleDriver");

			final Connection connection = DBConnection.getConnection();
		    final PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setString(1,product.getProductName());
			preparedStatement.setString(2,product.getProductSize());
			preparedStatement.setString(3,product.getKey_ingredients());
			preparedStatement.setString(4,product.getSkinType());
			preparedStatement.setString(5,product.getBenefit());
			preparedStatement.setInt(6,product.getQuantity());
			preparedStatement.setDouble(7,product.getPrice());
			preparedStatement.setString(8,product.getImage_url());

			preparedStatement.setInt(9,product.getCategoryId());
			preparedStatement.setString(10,product.getBrandName());
			final int noOrRows = preparedStatement.executeUpdate();
			if (noOrRows > 0) {
				return product;
			}

			preparedStatement.close();
			connection.close();
			throw new SQLIntegrityConstraintViolationException("Duplicate Primary key");
		
		
			
		
		
	
	}
		catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return product;
		
			
	}

	@Override
	public List<Product> getAllProducts() {

		List<Product> productList = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			final Connection connection = DBConnection.getConnection();
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(
					"SELECT PRODUCT_ID, PRODUCT_NAME,PRODUCT_SIZE,KEY_INGREDIENTS, SKIN_TYPE,BENEFIT, QUANTITY, PRICE, RATING, IMAGE_URL, CATEGORY_ID, BRAND_NAME  FROM PRODUCTS ");
			while (resultSet.next()) {
				Product product = new Product(resultSet.getInt("PRODUCT_ID"), resultSet.getString("PRODUCT_NAME"),
						resultSet.getString("PRODUCT_SIZE"), resultSet.getString("KEY_INGREDIENTS"),
						resultSet.getString("SKIN_TYPE"), resultSet.getString("BENEFIT"), resultSet.getInt("QUANTITY"),
						resultSet.getDouble("PRICE"), resultSet.getDouble("RATING"), resultSet.getString("IMAGE_URL"),
						resultSet.getInt("CATEGORY_ID"), resultSet.getString("BRAND_NAME")

				);
				System.out.println(resultSet.getString("BRAND_NAME"));
				productList.add(product);
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

		return productList;
	}

	@Override
	public Product getProductById(int productId) {
		Product product = null;
		try {
			final String select = "SELECT PRODUCT_ID, PRODUCT_NAME,PRODUCT_SIZE,KEY_INGREDIENTS, SKIN_TYPE,BENEFIT, QUANTITY, PRICE, RATING, IMAGE_URL, CATEGORY_ID, BRAND_NAME  FROM PRODUCTS "
					+ "WHERE PRODUCT_ID = ?";
			Class.forName("oracle.jdbc.driver.OracleDriver");

			final Connection connection = DBConnection.getConnection();
			final PreparedStatement preparedStatement = connection.prepareStatement(select);
			preparedStatement.setInt(1, productId);
			final ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				product = new Product(resultSet.getInt("PRODUCT_ID"), resultSet.getString("PRODUCT_NAME"),
						resultSet.getString("PRODUCT_SIZE"), resultSet.getString("KEY_INGREDIENTS"),
						resultSet.getString("SKIN_TYPE"), resultSet.getString("BENEFIT"), resultSet.getInt("QUANTITY"),
						resultSet.getDouble("PRICE"), resultSet.getDouble("RATING"), resultSet.getString("IMAGE_URL"),
						resultSet.getInt("CATEGORY_ID"), resultSet.getString("BRAND_NAME")

				);

			}
			resultSet.close();
			preparedStatement.close();
			connection.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return product;

	}

	@Override
	public List<Product> getProductByName(String productName) {

		List<Product> productList = new ArrayList<>();
		try {
			final String select = "SELECT PRODUCT_ID, PRODUCT_NAME,PRODUCT_SIZE,KEY_INGREDIENTS, SKIN_TYPE,BENEFIT, QUANTITY, PRICE, RATING, IMAGE_URL, CATEGORY_ID, BRAND_NAME  FROM PRODUCTS "
					+ "WHERE PRODUCT_NAME = ?";
			Class.forName("oracle.jdbc.driver.OracleDriver");

			final Connection connection = DBConnection.getConnection();
			final PreparedStatement preparedStatement = connection.prepareStatement(select);
			preparedStatement.setString(1, productName);
			final ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
			Product	product = new Product(resultSet.getInt("PRODUCT_ID"), resultSet.getString("PRODUCT_NAME"),
						resultSet.getString("PRODUCT_SIZE"), resultSet.getString("KEY_INGREDIENTS"),
						resultSet.getString("SKIN_TYPE"), resultSet.getString("BENEFIT"), resultSet.getInt("QUANTITY"),
						resultSet.getDouble("PRICE"), resultSet.getDouble("RATING"), resultSet.getString("IMAGE_URL"),
						resultSet.getInt("CATEGORY_ID"), resultSet.getString("BRAND_NAME")

				);
			productList.add(product);

			}
			resultSet.close();
			preparedStatement.close();
			connection.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public List<Product> getProductByBrand(String brandName) {

		List<Product> productList = new ArrayList<>();
		try {
			final String select = "SELECT PRODUCT_ID, PRODUCT_NAME,PRODUCT_SIZE,KEY_INGREDIENTS, SKIN_TYPE,BENEFIT, QUANTITY, PRICE, RATING, IMAGE_URL, CATEGORY_ID, BRAND_NAME  FROM PRODUCTS "
					+ "WHERE BRAND_NAME = ?";

			Class.forName("oracle.jdbc.driver.OracleDriver");

			final Connection connection = DBConnection.getConnection();
			final PreparedStatement preparedStatement = connection.prepareStatement(select);
			preparedStatement.setString(1, brandName.toString());
			final ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
			Product	product = new Product(resultSet.getInt("PRODUCT_ID"), resultSet.getString("PRODUCT_NAME"),
						resultSet.getString("PRODUCT_SIZE"), resultSet.getString("KEY_INGREDIENTS"),
						resultSet.getString("SKIN_TYPE"), resultSet.getString("BENEFIT"), resultSet.getInt("QUANTITY"),
						resultSet.getDouble("PRICE"), resultSet.getDouble("RATING"), resultSet.getString("IMAGE_URL"),
						resultSet.getInt("CATEGORY_ID"), resultSet.getString("BRAND_NAME")

				);
			System.out.println(resultSet.getString("BRAND_NAME"));
			productList.add(product);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public Boolean updateProduct(int id, Product product) {

		try {
			  

			Class.forName("oracle.jdbc.driver.OracleDriver");

			final Connection connection = DBConnection.getConnection();

			final String updateRecord = "update Products set " + " QUANTITY=?," + " PRICE=?," + "IMAGE_URL =?,"

					+ " where  PRODUCT_ID =?";

			final PreparedStatement preparedStatement = connection.prepareStatement(updateRecord);
			preparedStatement.setInt(1, product.getQuantity());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setString(3, product.getImage_url());
			if (preparedStatement.executeUpdate() > 0) {
				return true;
			}

			preparedStatement.close();
			connection.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;

	}

	@Override
	public List<Product> sortProductByName() throws SQLException {
		List<Product> productList = new ArrayList<>();

		ProductDao productDa = new ProductDao();
		Comparator<Product> products = (product1, product2) -> product2.getProductName()
				.compareTo(product1.getProductName());
		productList = productDa.getAllProducts().stream().sorted(products).toList();
		return productList;
	}

	@Override
	public List<Product> sortProductByBrand() throws SQLException {

		List<Product> productList = new ArrayList<>();

		ProductDao productDa = new ProductDao();
		Comparator<Product> products = (product1, product2) -> product2.getBrandName()
				.compareTo(product1.getBrandName());
		productList = productDa.getAllProducts().stream().sorted(products).toList();
		return productList;
	}

	@Override
	public List<Product> filterProductByCatogory() {

		return null;
	}

	@Override
	public List<Product> getAllProductsByCategory(int id) throws SQLException {
		List<Product> productList = new ArrayList<>();
		try {
			String select = "SELECT PRODUCT_ID, PRODUCT_NAME,PRODUCT_SIZE,KEY_INGREDIENTS, SKIN_TYPE,BENEFIT, QUANTITY, PRICE, RATING, IMAGE_URL, CATEGORY_ID, BRAND_NAME  FROM PRODUCTS "
					+ "WHERE CATEGORY_ID = ?";
			final Connection connection = DBConnection.getConnection();
			final PreparedStatement preparedStatement = connection.prepareStatement(select);
			preparedStatement.setInt(1, id);
			final ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Product product = new Product(resultSet.getInt("PRODUCT_ID"), resultSet.getString("PRODUCT_NAME"),
						resultSet.getString("PRODUCT_SIZE"), resultSet.getString("KEY_INGREDIENTS"),
						resultSet.getString("SKIN_TYPE"), resultSet.getString("BENEFIT"), resultSet.getInt("QUANTITY"),
						resultSet.getDouble("PRICE"), resultSet.getDouble("RATING"), resultSet.getString("IMAGE_URL"),
						resultSet.getInt("CATEGORY_ID"), resultSet.getString("BRAND_NAME")

				);
				productList.add(product);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return productList;

	}

	@Override
	public List<Product> filterProductByPriceLowToHigh() throws SQLException {
		 
		List<Product> productList = new ArrayList<>();

		ProductDao productDa = new ProductDao();
		Comparator<Product> products = (product1, product2) -> ((int)(product1.getPrice()-product2.getPrice()));
		productList = productDa.getAllProducts().stream().sorted(products).collect(Collectors.toList());
		System.out.println(productList);
		return productList;
	}

	@Override
	public List<Product> filterProductByPriceHighToLow() throws SQLException {
		
		List<Product> productList = new ArrayList<>();

		ProductDao productDa = new ProductDao();
		Comparator<Product> products = ( product2,product1) -> ((int)(product1.getPrice()-product2.getPrice()));
		productList = productDa.getAllProducts().stream().sorted(products).collect(Collectors.toList());
		return productList;
	}

}