package com.live_glow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.live_glow.model.Person;
import com.live_glow.util.DBConnection;

public class Person_Dao {

	public Person insertPerson(Person person) {
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			final Connection conn=DBConnection.getConnection();
			
			final String insertUpdate="insert into PERSON(PERSON_ID ,PERSON_NAME ,PASS_WORD , EMAIL ,ADDRESS ,CONTACT_NUMBER ,PERSON_TYPE) values(?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = conn.prepareStatement(insertUpdate);
				preparedStatement.setInt(1,7);
				preparedStatement.setString(2,person.getPersonName());
				preparedStatement.setString(3,person.getPassword());
				preparedStatement.setString(4,person.getEmail());
				preparedStatement.setString(5,person.getAddress());
				preparedStatement.setLong(6,person.getContactNo());
				preparedStatement.setString(7, "CUSTOMER");
				ResultSet rs=preparedStatement.executeQuery();
				preparedStatement.close();
				}
			catch(SQLException e) {
				e.printStackTrace();
			}
		return person;

		
	}
	
	public Person personLogin(String email, String password) throws SQLException {
		Person person = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		final Connection conn=DBConnection.getConnection();

		try {
			String sql = "SELECT * FROM PERSON WHERE EMAIL=? AND PASS_WORD=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(2, password);
			pst.setString(1, email);
			final ResultSet rs=pst.executeQuery();
			System.out.println("rs1"+rs);
			
			
			if (rs.next()) {	
				person=new Person();
				
				person.setPersonId(rs.getInt(1));
				person.setPersonName(rs.getString(2));
				person.setPassword(rs.getString(3));
				person.setEmail(rs.getString(4));
				person.setAddress(rs.getString(5));
				person.setContactNo(rs.getLong(6));
				person.setPersonType(rs.getString(7));
				System.out.println("person:"+person);
			}
			rs.close();
			pst.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return person;
		
	
	}
	
	public Person getPersonById(int PersonId) throws SQLException {
		Person person=null;
		final Connection conn=DBConnection.getConnection();
		String query="SELECT * FROM PERSON WHERE PERSON_ID=?";
		PreparedStatement preparedStatement=conn.prepareStatement(query);
		preparedStatement.setInt(1, PersonId);
		final ResultSet rs=preparedStatement.executeQuery();
		while(rs.next()) {
		person=new Person();
		person.setPersonId(rs.getInt(1));
		person.setPersonName(rs.getString(2));
		person.setPassword(rs.getString(3));
		person.setEmail(rs.getString(4));
		person.setAddress(rs.getString(5));
		person.setContactNo(rs.getLong(6));
		person.setPersonType(rs.getString(7));
		}
		System.out.println(person);
		return person;
	}

}