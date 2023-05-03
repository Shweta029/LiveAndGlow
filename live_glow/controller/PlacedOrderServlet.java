package com.live_glow.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.live_glow.dao.OrderDao;
import com.live_glow.model.Order;
import com.live_glow.model.Person;

/**
 * Servlet implementation class PlacedOrderServlet
 */
public class PlacedOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Person person = new Person();
			Order order = new Order();

			int pid = Integer.parseInt(request.getParameter("id"));
			int prid = Integer.parseInt(request.getParameter("prid"));

			String name = request.getParameter(person.getPersonName());
			String email = request.getParameter(person.getEmail());
			String address = request.getParameter(person.getAddress());
			String paymentType = request.getParameter(order.getPaymentType());

			Order order1 = null;
			OrderDao orderDao = new OrderDao();
			List<Order> olist = orderDao.personOrders(prid);
			for (Order o : olist) {
				System.out.println(o.getProduct().getProductName());
			}
			
			  Random r = new Random(); 
			  ArrayList<Order> allorderlist = new ArrayList<Order>();
			  
			  for(Order o: olist) {
				  order1=new Order();
				  order1.setOrderId(o.getOrderId()+ r.nextInt(1000));
				  order1.setPersonId(prid); 
				  order1.setProductId(pid);
				  order1.setPersonName(name); 
				  order1.setEmail(email);
				  order1.setContactNo(person.getContactNo()); 
				  order1.setAddress(address);
				  order1.setPrice(order.getPrice()); 
				  order1.setPaymentType(paymentType);
				  allorderlist.add(order1);
			  }
			  
				
				  if("noselect".equals(paymentType)) { session.setAttribute("msg",
				  "Please choose payment method!!"); response.sendRedirect("PlacedOrder.jsp");
				  } else {
				  
			  boolean b = orderDao.allOrder(allorderlist); 
			  	if(b) {
						System.out.println(order1); 
						System.out.println("My orders are"+allorderlist);
						System.out.println(olist); 
						System.out.println("Order Success"); 
					  } else {
						  System.out.println("Order Failed"); 
					  } 
			  }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
