package com.live_glow.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.live_glow.dao.ProductDao;
import com.live_glow.model.Product;

/**
 * Servlet implementation class Filter
 */
public class Filter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  Product product;
      ProductDao productDao;
   
      
      public static String convertToTitleCase(String text) {
  	    if (text == null || text.isEmpty()) {
  	        return text;
  	    }

  	    StringBuilder converted = new StringBuilder();

  	    boolean convertNext = true;
  	    for (char ch : text.toCharArray()) {
  	        if (Character.isSpaceChar(ch)) {
  	            convertNext = true;
  	        } else if (convertNext) {
  	            ch = Character.toTitleCase(ch);
  	            convertNext = false;
  	        } else {
  	            ch = Character.toLowerCase(ch);
  	        }
  	        converted.append(ch);
  	    }

  	    return converted.toString();
  	}
    public Filter() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init() throws ServletException {
		
		super.init();
		productDao  = new ProductDao();
		Product product = new Product();
    }
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> list = null;
		  
		 
		 HttpSession session = request.getSession();
		String price;	
		 try {
			
			price  = request.getQueryString();
			  System.out.println(price);
			  if(price.equalsIgnoreCase("low"))
			  {
				  list = productDao.filterProductByPriceLowToHigh();
				  request.setAttribute("products",list);
				  System.out.println(list);
				  
				  			  }			  else if(price.equalsIgnoreCase("high")) {
				  list = productDao.filterProductByPriceHighToLow();				  request.setAttribute("products",list);
				  System.out.println(list);
			  }
			  else {
				  
				  list = productDao.getAllProducts();
			   System.out.println(list);
			  request.setAttribute("products",list);
			  }
			    System.out.println(list);
			  RequestDispatcher requestDispatcher =
					  request.getRequestDispatcher("search.jsp");
					  
					  requestDispatcher.forward(request, response);
					  return;
		   
		     
//	         
//	      
//			  
//				/*
//				 * RequestDispatcher requestDispatcher =
//				 * request.getRequestDispatcher("search.jsp");
//				 * 
//				 * requestDispatcher.forward(request, response);
//				 */
//				 
//				 response.sendRedirect("search.jsp");
	         
		
			 
	}
	  catch (SQLException e) {
		  
	  
			e.printStackTrace();
	  }
		 catch (Exception e) {
			  
			  
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