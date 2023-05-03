package com.live_glow.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.live_glow.dao.Person_Dao;
import com.live_glow.dao.ProductDao;
import com.live_glow.model.Person;
import com.live_glow.model.Product;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductDao productDao;
	private Person_Dao person_Dao;

	/**
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductController() {
		super();
		// TODO Auto-generated constructor stub

	}

	public void init() {
		productDao = new ProductDao();
		person_Dao = new Person_Dao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/jsp");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));

		ProductDao pd = new ProductDao();
		Product p = new Product();
		p = pd.getProductById(id);

		String url = "product-detail.jsp?id=" + id;
        request.setAttribute("p", p);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

//		
		System.out.println(id);
		try {

			List<Product> productList = new ArrayList<>();
			productList = productDao.getAllProducts();

			Person person = person_Dao.personLogin("john@gmail.com", "123");
			System.out.println("PERSON" + person);
			productDao.getAllProducts().stream().forEach(System.out::print);
			System.out.println("by id");
			Product productbyId = productDao.getProductById(2);
			System.out.println(productbyId);
			/*
			 * System.out.println("by name"); Product productbyname =
			 * productDao.getProductByName("ertyuio"); System.out.println(productbyname);
			 * System.out.println("by brand"); Product productbybrand =
			 * productDao.getProductByBrand("MAMAEARTH");
			 * System.out.println(productbybrand);
			 */

			productList = productDao.sortProductByName();
			System.out.println(productList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}