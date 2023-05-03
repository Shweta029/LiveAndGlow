package com.live_glow.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.live_glow.dao.Person_Dao;
import com.live_glow.model.Person;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    	String personName =request.getParameter("personName");
		String password =request.getParameter("password");
		String email =request.getParameter("email");
		String address =request.getParameter("address");
	    long contactNumber = Long.parseLong(request.getParameter("ContactNumber"));
		Person person=new Person();
		person.setPersonName(personName);
		person.setPassword(password);
		person.setEmail(email);
		person.setAddress(address);
		person.setContactNo(contactNumber);
		
		Person_Dao dao=new Person_Dao();
		Object p = dao.insertPerson(person);
		if (p!=null) {
			response.sendRedirect("login.jsp");
			
		}
		else {
			response.sendRedirect("registration.jsp");
		}

	}

}