package com.live_glow.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.live_glow.dao.Person_Dao;
import com.live_glow.model.Person;
import com.live_glow.util.DBConnection;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("login_email").trim();
			String password = request.getParameter("login_password").trim();
			System.out.println(email);
			System.out.println(password);

			Person_Dao pdao = new Person_Dao();
			Person person = new Person();
			person.setEmail(email);
			person.setPassword(password);

			HttpSession session = request.getSession();

			Object auth = pdao.personLogin(email, password);
			System.out.println("auth:" + auth);
			if("a@gmail.com".equals(email) && "admin12".equals(password)) {
				response.sendRedirect("AdminDashboard.jsp");
			}
			else {
			if (auth != null) {
				
				session.setAttribute("auth", auth);
				out.print("user login");
				response.sendRedirect("main.jsp");
				session.setAttribute("snackbarMess", "Login Successfull");

			} else {
				out.print("user login failed");
				session.setAttribute("snackbarMess", "Invalid Email/Password");
				response.sendRedirect("login.jsp");
				
			}
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
