/*
 * package com.live_glow.controller;
 * 
 * import java.io.IOException; import java.io.PrintWriter; import
 * java.sql.SQLException; import java.util.ArrayList;
 * 
 * import javax.servlet.ServletException; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import com.live_glow.dao.cartDao; import com.live_glow.model.Cart;
 * 
 * public class ChangeQuantityServlet extends HttpServlet { private static final
 * long serialVersionUID = 1L;
 * 
 * Cart cart = new Cart(); int pid;
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doGet(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException {
		 * 
		 * PrintWriter out = response.getWriter();
		 * 
		 * String action = request.getParameter("act"); int id =
		 * Integer.parseInt(request.getParameter("id")); int prid =
		 * Integer.parseInt(request.getParameter("prid")); String location =
		 * request.getParameter("location"); Cart cart = new Cart(); cartDao cd = new
		 * cartDao();
		 * 
		 * HttpSession session = request.getSession(); ArrayList<Cart> cart_list =
		 * (ArrayList<Cart>) session.getAttribute("cart-list");
		 * System.out.println("cart_list 123" + cart_list); System.out.println("action"
		 * + action); boolean exist = false; if (action != null && id >= 1 &&
		 * location.equals("Cart")) {
		 * 
		 * System.out.println("id" + id); if (action.equals("inc")) {
		 * 
		 * for (Cart c : cart_list) { if (c.getProduct().getProductId() == id) {
		 * System.out.println(c.getProduct().getProductId()); exist = true;
		 * System.out.println("hey"); int quantity = c.getQuantity(); quantity++;
		 * c.setQuantity(quantity); response.sendRedirect("Cart.jsp"); try {
		 * cd.updateQuantity(prid, id, quantity); } catch (SQLException e) {
		 * e.printStackTrace(); } }
		 * 
		 * }
		 * 
		 * }
		 * 
		 * if (action.equals("dec")) { for (Cart c : cart_list) { if
		 * (c.getProduct().getProductId() == id && c.getQuantity() > 1) {
		 * System.out.println(c.getProduct().getProductId()); exist = true;
		 * System.out.println("decre"); int quantity = c.getQuantity(); quantity--;
		 * c.setQuantity(quantity); response.sendRedirect("Cart.jsp"); try {
		 * cd.updateQuantity(prid, id, quantity); } catch (SQLException e) {
		 * e.printStackTrace(); } }
		 * 
		 * }
		 * 
		 * }
		 * 
		 * } else if (location.equals("PlacedOrder")) { Cart orderNowList = (Cart)
		 * session.getAttribute("order_now_list"); if (action.equals("inc")) { int
		 * quantity = orderNowList.getQuantity(); quantity++;
		 * orderNowList.setPrice(orderNowList.getProduct().getPrice() * quantity);
		 * orderNowList.setQuantity(quantity); response.sendRedirect("PlacedOrder.jsp");
		 * session.setAttribute("order_now_list", orderNowList); }
		 * 
		 * if (action.equals("dec")) { int quantity = orderNowList.getQuantity(); if
		 * (quantity > 1) { quantity--;
		 * orderNowList.setPrice(orderNowList.getProduct().getPrice() * quantity);
		 * orderNowList.setQuantity(quantity); session.setAttribute("order_now_list",
		 * orderNowList); } response.sendRedirect("PlacedOrder.jsp"); }
		 * 
		 * if (action.equals("rm")) { session.removeAttribute("order_now_list");
		 * response.sendRedirect("index.jsp"); } } }
		 * 
		 * }
		 */

package com.live_glow.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.live_glow.dao.cartDao;
import com.live_glow.model.Cart;

public class ChangeQuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Cart cart = new Cart();
	int pid;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String action = request.getParameter("act");
		int id = Integer.parseInt(request.getParameter("id"));
		int prid = Integer.parseInt(request.getParameter("prid"));
		String location = request.getParameter("location");
		Cart cart = new Cart();
		cartDao cd = new cartDao();

		HttpSession session = request.getSession();
		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
		System.out.println("cart_list 123" + cart_list);
		System.out.println("action" + action);
		boolean exist = false;
		if (action != null && id >= 1 && location.equals("Cart")) {

			System.out.println("id" + id);
			if (action.equals("inc")) {

				for (Cart c : cart_list) {
					if (c.getProduct().getProductId() == id) {
						System.out.println(c.getProduct().getProductId());
						exist = true;
						System.out.println("hey");
						int quantity = c.getQuantity();
						quantity++;
						c.setQuantity(quantity);
						response.sendRedirect("Cart.jsp");
						try {
							cd.updateQuantity(prid, id, quantity);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}

				}

			}

			if (action.equals("dec")) {
				for (Cart c : cart_list) {
					if (c.getProduct().getProductId() == id && c.getQuantity() > 1) {
						System.out.println(c.getProduct().getProductId());
						exist = true;
						System.out.println("decre");
						int quantity = c.getQuantity();
						quantity--;
						c.setQuantity(quantity);
						response.sendRedirect("Cart.jsp");
						try {
							cd.updateQuantity(prid, id, quantity);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}

				}

			}

		} else if (location.equals("PlacedOrder")) {
			Cart orderNowList = (Cart) session.getAttribute("order_now_list");
			if (action.equals("inc")) {
				int quantity = orderNowList.getQuantity();
				quantity++;
				orderNowList.setPrice(orderNowList.getProduct().getPrice() * quantity);
				orderNowList.setQuantity(quantity);
				response.sendRedirect("PlacedOrder.jsp");
				session.setAttribute("order_now_list", orderNowList);
			}

			if (action.equals("dec")) {
				int quantity = orderNowList.getQuantity();
				if (quantity > 1) {
					quantity--;
					orderNowList.setPrice(orderNowList.getProduct().getPrice() * quantity);
					orderNowList.setQuantity(quantity);
					session.setAttribute("order_now_list", orderNowList);
				}
				response.sendRedirect("PlacedOrder.jsp");
			}
			
			if (action.equals("rm")) {
				session.removeAttribute("order_now_list");
				response.sendRedirect("index.jsp");
			}
		}
	}

}