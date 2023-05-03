package com.live_glow.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditProduct extends HttpServlet {
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int productId=Integer.parseInt(request.getParameter("id"));
			String productName=request.getParameter("productName");
		
		String productSize=request.getParameter("productSize");
		String key_ingredients=request.getParameter("key_ingredients");
		String skinType=request.getParameter("skinType");
		String benefit=request.getParameter("benefit");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		double price= Double.parseDouble(request.getParameter("price"));
		String image_url = request.getParameter("image_url");
		int  categoryId=Integer.parseInt(request.getParameter("categoryId"));
		
		String  brandName=request.getParameter("brandName");	
	
	} catch(Exception e) {
		e.printStackTrace();
	}
	}

}
