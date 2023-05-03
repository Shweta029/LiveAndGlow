package com.live_glow.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.live_glow.util.SendMail;

public class Mail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Mail() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    public void doGet(HttpServletRequest request,  
    		 HttpServletResponse response)  
    		    throws ServletException, IOException {  
    		  
    		    response.setContentType("text/html");  
    		    PrintWriter out = response.getWriter();  
    		      
    		    String to=request.getParameter("to");  
    		    System.out.println("to :" + to);
    		    String subject=request.getParameter("subject");  
    		    String msg=request.getParameter("msg");  
    		        SendMail sendMail = new SendMail();  
    		   boolean f =  sendMail.send(to, subject, msg);  
	    		   if (f) {
	    	            System.out.println("Email is sent successfully");
	    	        } else {
	    	            System.out.println("There is problem in sending email");
	    	        }
    		   
    		    out.print("message has been sent successfully");  
    		    out.close();  
    }
}