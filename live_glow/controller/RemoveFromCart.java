
package com.live_glow.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.live_glow.dao.cartDao;
import com.live_glow.model.Cart;
import com.live_glow.model.Product;

/**
 * Servlet implementation class RemoveFromCart
 */
public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			HttpSession session= request.getSession();
			int id = Integer.parseInt(request.getParameter("id"));
			int prid= Integer.parseInt(request.getParameter("prid"));
			Cart cart =new Cart();
			cartDao cd = new cartDao(); 
			if (id > 0) {
				ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
				if (cart_list != null) {
					for (Cart c : cart_list) {
						if (c.getProduct().getProductId() == id) {
							cart_list.remove(cart_list.indexOf(c));
							break;
						}
					}
				}
				response.sendRedirect("Cart.jsp");
				try {
					cd.removeProduct(prid, id);
					session.setAttribute("snackbarMess", "Removed from cart");
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} else {
				response.sendRedirect("Cart.jsp");
			}

		}

	
	}
	}