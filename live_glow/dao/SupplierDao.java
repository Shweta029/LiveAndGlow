package com.live_glow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.live_glow.model.Supplier;
import com.live_glow.util.DBConnection;

public class SupplierDao implements ISupplier<Supplier> {

	private static final Boolean Supplier = null;

	@Override
	public List<Supplier> findAll() throws SQLException, ClassNotFoundException {
		final List<Supplier> SupplierList = new ArrayList<>();

          Class.forName("oracle.jdbc.driver.OracleDriver");
		final Connection connection = DBConnection.getConnection();
		final Statement sellectAllSupplier = connection.createStatement();
		final String select = "SELECT SUPPLIER_ID,SUPPLIER_NAME,COMPANY_NAME,EMAIL from SUPPLIER";
		final ResultSet resultSet = sellectAllSupplier.executeQuery(select);
		while (resultSet.next()) {
			Supplier s = new Supplier(resultSet.getInt("SUPPLIER_ID"), resultSet.getString("SUPPLIER_NAME"),
					resultSet.getString("COMPANY_NAME"), resultSet.getString("EMAIL"));

			SupplierList.add(s);
		}
		resultSet.close();
		sellectAllSupplier.close();
		connection.close();
		return SupplierList;
	}

	@Override
	public Supplier findOneById(int id) throws SQLException, ClassNotFoundException {
		Supplier supplier = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		final Connection connection = DBConnection.getConnection();

		final String select = "SELECT SUPPLIER_ID, SUPPLIER_NAME,COMPANY_NAME,EMAIL FROM SUPPLIER"
				+ " WHERE SUPPLIER_ID=?";

		final PreparedStatement preparedStatement = connection.prepareStatement(select);
		preparedStatement.setInt(1, id);

		final ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			supplier = new Supplier(resultSet.getInt("SUPPLIER_ID"), resultSet.getString("SUPPLIER_NAME"),
					resultSet.getString("COMPANY_NAME"), resultSet.getString("EMAIL")

			);
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return supplier;
	}

	@Override
	public Supplier findOneByName(String name) throws SQLException, ClassNotFoundException {
		Supplier supplier = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		final Connection connection = DBConnection.getConnection();

		final String select = "SELECT SUPPLIER_ID, SUPPLIER_NAME,COMPANY_NAME,EMAIL FROM SUPPLIER"
				+ " WHERE SUPPLIER_NAME=?";
		final PreparedStatement preparedStatement = connection.prepareStatement(select);
		preparedStatement.setString(1, name);

		final ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			supplier = new Supplier(resultSet.getInt("SUPPLIER_ID"), resultSet.getString("SUPPLIER_NAME"),
					resultSet.getString("COMPANY_NAME"), resultSet.getString("EMAIL")

			);
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return supplier;

	}

	@Override
	public Supplier findOneByCompany(String company_name) throws SQLException, ClassNotFoundException {
		Supplier supplier = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		final Connection connection = DBConnection.getConnection();

		final String select = "SELECT SUPPLIER_ID, SUPPLIER_NAME,COMPANY_NAME,EMAIL FROM SUPPLIER"
				+ " WHERE COMPANY_NAME=?";
		final PreparedStatement preparedStatement = connection.prepareStatement(select);
		preparedStatement.setString(1, company_name);

		final ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			supplier = new Supplier(resultSet.getInt("SUPPLIER_ID"), resultSet.getString("SUPPLIER_NAME"),
					resultSet.getString("COMPANY_NAME"), resultSet.getString("EMAIL")

			);
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return supplier;
	}

	@Override
	public Supplier addSupplier(Supplier s) throws SQLException, ClassNotFoundException {
		Supplier Supplier = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		final Connection connection = DBConnection.getConnection();
		final String insertUpdate = "insert into SUPPLIER( SUPPLIER_ID, SUPPLIER_NAME,COMPANY_NAME,EMAIL) values(supplier_1.nextval,?,?,?)";
		final PreparedStatement preparedStatement = connection.prepareStatement(insertUpdate);
//		preparedStatement.setDouble(1, s.getSupplier_id());
		preparedStatement.setString(1, s.getSupplier_name());
		preparedStatement.setString(2, s.getCompany_name());
		preparedStatement.setString(3, s.getEmail());
		final int noOrRows = preparedStatement.executeUpdate();
		if (noOrRows > 0) {
			return s;
		}

		preparedStatement.close();
		connection.close();
		throw new SQLIntegrityConstraintViolationException("Duplicate Primary key");
	}

	@Override
	public com.live_glow.model.Supplier findOneByEmail(String email) throws SQLException, ClassNotFoundException {

		Supplier supplier = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		final Connection connection = DBConnection.getConnection();

		final String select = "select SUPPLIER_ID,SUPPLIER_NAME, COMPANY_NAME,EMAIL from SUPPLIER" + " where email=?";
		final PreparedStatement preparedStatement = connection.prepareStatement(select);
		preparedStatement.setString(1, email);

		final ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			supplier = new Supplier();

			supplier.setSupplier_id(resultSet.getInt("SUPPLIER_ID"));
			supplier.setSupplier_name(resultSet.getString("SUPPLIER_NAME"));
			supplier.setCompany_name(resultSet.getString("COMPANY_NAME"));
			supplier.setEmail(resultSet.getString("EMAIL"));

		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return supplier;
	}

	

}