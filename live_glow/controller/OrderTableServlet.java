package com.live_glow.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.live_glow.dao.OrderDao;
import com.live_glow.model.Cart;
import com.live_glow.model.NewOrder;
import com.live_glow.model.Person;

/**
 * Servlet implementation class OrderTableServlet
 */
public class OrderTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    String payment = request.getParameter("payment");
	    int quantity = Integer.parseInt(request.getParameter("quantity")); // parse string to int
	    Cart orderNowCart = (Cart) session.getAttribute("order_now_list");
	    int productId = orderNowCart.getProductId();
	    Person person = (Person) session.getAttribute("auth");
	    int userId = person.getPersonId();
	    
	    NewOrder order = new NewOrder();
	    order.setPaymentType(payment);
	    order.setQuantity(quantity);
	    order.setProductId(productId);
	    order.setPersonId(userId);

	    OrderDao orderDao = new OrderDao();
	    boolean result = orderDao.insertOrder(order);
	    if(result) {
	    	response.sendRedirect("OrderSuccess.jsp");
	    } else {
	    	PrintWriter out = response.getWriter();
			out .print("Order Failed");
	    }
	}


}
