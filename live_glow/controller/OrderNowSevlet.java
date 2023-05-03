package com.live_glow.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.live_glow.dao.OrderDao;
import com.live_glow.dao.ProductDao;
import com.live_glow.model.Cart;
import com.live_glow.model.Order;
import com.live_glow.model.Person;
import com.live_glow.model.Product;

/**
 * Servlet implementation class OrderNowSevlet
 */
public class OrderNowSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Person person = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {

			/* SimpleDateFormat date = new SimpleDateFormat("dd-mm-yyyy"); */
			Date date = new Date();
			

			HttpSession session = request.getSession();
			/* Person person = new Person(); */
			/* Object auth= person.getPersonId(); */

			person = (Person) session.getAttribute("person");
			/*
			 * int pId=person.getPersonId();
			 */
			int prid = Integer.parseInt(request.getParameter("prid").trim());
			System.out.println(person);
			if (prid == -1) {
				response.sendRedirect("login.jsp");
				return;
			}
			int pId = prid;
			if (pId > 0) {
				System.out.println("person ki id:" + pId);
				session.setAttribute("prid", person);
				int id = Integer.parseInt(request.getParameter("id").trim());

				int quantity = Integer.parseInt(request.getParameter("quantity"));
				if (quantity <= 0) {
					quantity = 1;
				}

				Order O = new Order();
				O.setProductId(id);
				O.setPersonId(pId);
				O.setQuantity(quantity);
				O.setOrderDate(date);

				OrderDao orderDao = new OrderDao();
				ProductDao productDao = new ProductDao();
				Product product = productDao.getProductById(id);
				Cart cart= new Cart();
				cart.setImage_url(product.getImage_url());
				cart.setProductName(product.getProductName());
				cart.setPrice(product.getPrice());
				cart.setProduct(product);
				cart.setProductId(id);
				cart.setQuantity(quantity);
				
				session.setAttribute("order_now_list", cart);
//				boolean result = orderDao.insertOrder(O);
				
				/* System.out.println("personid:"+person.getPersonId()); */
//				if (result) {
					
					response.sendRedirect("PlacedOrder.jsp");
//				} else {
//					out.print("Failed to order!!");
//				}

			} else {
				response.sendRedirect("login.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
