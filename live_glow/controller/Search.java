package com.live_glow.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.live_glow.model.Product;
import com.live_glow.dao.ProductDao;


public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Product product;
       ProductDao productDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
       
       
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
    public Search() {
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
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		  
		  
		  
		  List<Product> list;
			 
		  String keyword =  convertToTitleCase(request.getParameter("search"));
			
			/* list = productDao.getAllProducts(); */
			/* System.out.println(list); */
			/* request.setAttribute("products",productDao.getAllProducts() ); */
			System.out.println("search "+ keyword);
			
			if( keyword != null)
			{     
				  
				  
				 list = (ArrayList<Product>) productDao.getProductByName(keyword);
				 
				if(!list.isEmpty())
				{
				request.setAttribute("products",list );
				list.stream().forEach(System.out::print);
				return;
				}
				else if(list.isEmpty()) {
					
					list =productDao.getAllProducts().stream().filter(product -> product.getProductName().contains(keyword) ).collect(Collectors.toList());
					System.out.println("contains 2" + list);
					request.setAttribute("products",list );
					List<Product> p  =productDao.getAllProducts().stream().filter(product -> product.getProductName().contains(keyword) ).collect(Collectors.toList());

					System.out.println("contains 2" + list);
				}
				else
					
				{
					request.setAttribute("products",productDao.getAllProducts() );
				}
				
				
				
			}
			else
			{
				System.out.println("contains 2" + productDao.getAllProducts());
				request.setAttribute("products",productDao.getAllProducts() );
			}
			
			
			  
			
		  
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("search.jsp");
					  
/*					  requestDispatcher.forward(request, response);
*/					  requestDispatcher.forward(request, response);
				return;
	}

}