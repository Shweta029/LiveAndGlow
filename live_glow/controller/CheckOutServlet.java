package com.live_glow.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.live_glow.dao.OrderDao;
import com.live_glow.model.Cart;
import com.live_glow.model.NewOrder;
import com.live_glow.model.Order;
import com.live_glow.model.Person;


public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CheckOutServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			
			Date date = new Date();
			 HttpSession session = request.getSession(); 
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
			Person auth = (Person) session.getAttribute("auth");
			String payment = request.getParameter("payment");
			System.out.println(payment);
			if(auth!=null && cart_list!=null) {
				for (Cart c:cart_list) {
					
					NewOrder order = new NewOrder();
				    order.setPaymentType(payment);
				    order.setQuantity(c.getQuantity());
				    order.setProductId(c.getProduct().getProductId());
				    order.setPersonId(auth.getPersonId());

				    OrderDao orderDao = new OrderDao();
				    boolean result = orderDao.insertOrder(order);
				
					
					if(!result) {
						break;
					}
					
				}
				cart_list.clear();
				response.sendRedirect("OrderSuccess.jsp");
				
			}else {
				if(auth == null)response.sendRedirect("login.jsp");
				if(cart_list== null)response.sendRedirect("main.jsp");
			}
			
			 out.println("order");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}



}
