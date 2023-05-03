package com.live_glow.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.live_glow.dao.CategoryDao;
import com.live_glow.dao.ProductDao;

/**
 * Servlet implementation class CategoryController
 */


public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CategoryDao categoryDao;
       ProductDao  productDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	 public void init() {
	    	
	    }
    public CategoryController() {
        super();
       categoryDao = new CategoryDao();
       productDao = new ProductDao();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/jsp");
		PrintWriter out = response.getWriter();
		try {
			int id = Integer.parseInt(request.getParameter("id")); 
			System.out.println("id of cate"+  id);
			categoryDao.getAllCategorys().stream().forEach(System.out::println);
			productDao.getAllProductsByCategory(id).stream().forEach(System.out::println);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("productByCategory.jsp");
			requestDispatcher.forward(request, response);

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}