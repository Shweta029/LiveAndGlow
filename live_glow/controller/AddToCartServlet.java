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
import javax.swing.JOptionPane;

import com.live_glow.dao.ProductDao;
import com.live_glow.dao.cartDao;
import com.live_glow.model.*;

/**
 * Servlet implementation class AddToCartServlet
 */
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			// ArrayList<Cart> cartList = new ArrayList<>(); // create session of product by
			// calling an object

			Cart cart = new Cart();
			int id = Integer.parseInt(request.getParameter("id"));
			int prid = Integer.parseInt(request.getParameter("prid"));
			System.out.println("ID " + id);
			System.out.println("prid:" + prid);

			HttpSession session = request.getSession();

			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

			if (cart_list == null) {
				cart_list = new ArrayList<>();
				System.out.println("When cart is null");
				cart_list.add(cart);
				Cart c = new Cart();
				ProductDao pd = new ProductDao();
				cartDao cd = new cartDao();

				Product product = pd.getProductById(id);

				cart.setQuantity(1);
				cart.setProduct(product);
				try {

					System.out.println("prid:" + prid);
					cd.addToCart(id, prid, cart.getQuantity());

				} catch (SQLException e) {
					e.printStackTrace();
				}

				System.out.println("CART LIST " + cart_list);

				session.setAttribute("cart-list", cart_list);
				session.setAttribute("snackbarMess", "Added to cart.");
				response.sendRedirect("Cart.jsp");

				// session is created and added.
			} else {
				System.out.println("When cart is not null");
				/* cartList = cart_list; */ // if i have one product then add another one
				boolean exist = false;

				for (Cart c : cart_list) {
					if (c.getProduct().getProductId() == id) {
						exist = true;
						break;
					}
				}

				if (exist) {
					out.println(
							"<h3 style='color:crimson; text-align:center; background-image:url('src/main/webapp/assets/Images/c1.png);'>Item already exist in cart.<a href='Cart.jsp'>Go to cart page.</a></h3>");

				} else {
					cart_list.add(cart);
					out.println("product added");
					ProductDao pd = new ProductDao();
					cartDao cd = new cartDao();

					Product product = pd.getProductById(id);

					cart.setQuantity(1);
					cart.setProduct(product);
					try {

						System.out.println("prid:" + prid);
						cd.addToCart(id, prid, cart.getQuantity());

					} catch (SQLException e) {
						e.printStackTrace();
					}

					session.setAttribute("snackbarMess", "Added to cart.");
					response.sendRedirect("Cart.jsp");

					
				}
				System.out.println("CART LIST" + cart_list);

			}

			

		}
	}
}