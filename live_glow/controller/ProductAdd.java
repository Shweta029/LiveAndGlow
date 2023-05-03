package com.live_glow.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.live_glow.dao.ProductDao;
import com.live_glow.model.Product;

/**
 * Servlet implementation class AdminController
 */
public class ProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ProductAdd() {
        super();
    }

	
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub RequestDispatcher rd =
	 * request.getRequestDispatcher("Add_Product.jsp"); rd.forward(request,
	 * response);
	 * 
	 * }
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* doGet(request, response); */
		try {
//		int productId=Integer.parseInt(request.getParameter("productId"));
			String productName=request.getParameter("productName");
			String productSize=request.getParameter("productSize");
			String key_ingredients=request.getParameter("key_ingredients");
			String skinType=request.getParameter("skinType");
			String benefit=request.getParameter("benefit");
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			double price= Double.parseDouble(request.getParameter("price"));
			String image_url = request.getParameter("image_url");

			/*
			 * String image_url = request.getParameter("image_url");
			 */	
			/*
			 * Part part = request.getPathInfo();
			 * 
			 * String filename =part.getSubmittedFileName();
			 */
			
			
			
			int  categoryId=Integer.parseInt(request.getParameter("categoryId"));
			String  brandName=request.getParameter("brandName");
		    
			Product product=new Product();
			 
			product.setProductName(productName);
			product.setProductSize(productSize);
			product.setKey_ingredients(key_ingredients);
			product.setSkinType(skinType);
			product.setBenefit(benefit);
			product.setQuantity(quantity);
			product.setPrice(price);
			product.setImage_url(image_url);
			product.setCategoryId(categoryId);
			product.setBrandName(brandName);
			System.out.println(product);
			
			ProductDao pdao=new ProductDao();
			Product f=pdao.Add_Products(product);
			HttpSession session=request.getSession();
			if(f != null)
			{	
				/*
				 * String path=getServletContext().getRealPath("") + "ProductImg"; File file=
				 * new File(path); part.write(path+ File.separator +filename);
				 */
				System.out.println("hello");
				session.setAttribute("SuccMsg", "Product Added Successful");
				response.sendRedirect("All_Product.jsp");
				
			}else {
				session.setAttribute("failedMsg","Something wrong");
				response.sendRedirect("Add_Product.jsp");
				
			}

			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}