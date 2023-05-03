package com.live_glow.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.live_glow.dao.SupplierDao;
import com.live_glow.model.Supplier;


    
/**
 * Servlet implementation class SupplierControlleras
 */

public class SupplierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Supplier supplier=new Supplier(); 
    SupplierDao supplierDao = new SupplierDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException {
	  response.sendRedirect("supplier.jsp");
	  
	  
	  response.setContentType("text/jsp"); PrintWriter out = response.getWriter();
	 
	  //response.sendRedirect("supplier.jsp"); System.out.println("hello"); 
	  } 
	 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		  try {
			  
			  response.setContentType("text/jsp");
				PrintWriter out = response.getWriter();

				 String name = request.getParameter("username"); 
				  String cname= request.getParameter("Company_name");
				  String semail= request.getParameter("Email");
//					Supplier supplier =	supplierDao.findOneById(1);
					Supplier supplier = new Supplier();
					System.out.println("supplier"+ supplier);
				 
				  supplier.setSupplier_name(name);
				  supplier.setCompany_name(cname);
				  supplier.setEmail(semail);
				  System.out.println("fname"+name);
				  System.out.println("cname"+cname);
				  System.out.println("semail"+semail);
			supplierDao.addSupplier(supplier);
	
			System.out.println("fname"+name);
			  System.out.println("cname"+cname);
			  System.out.println("semail"+semail);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    		
	}

}