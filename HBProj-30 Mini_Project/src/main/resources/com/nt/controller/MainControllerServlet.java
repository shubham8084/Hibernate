package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.ProductDTO;
import com.nt.service.ProductMgntService;
import com.nt.service.ProductMngtServiceImpl;
@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	private ProductMgntService service;

	@Override
	public void init() throws ServletException {
		System.out.println("MainControllerServlet.init()");
		service = new ProductMngtServiceImpl();
	}

	@Override
	public void destroy() {
		service=null;
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("MainControllerServlet.doGet()");
		int id=0;
	      ProductDTO  dto=null;
	      RequestDispatcher rd=null;
		  //read form data..
	      id=Integer.parseInt(req.getParameter("pid"));
	      try {
		   //use service
	        dto=service.getProductDetails(id);
	        System.out.println(dto.getPid()+" "+dto.getPName()+" "+dto.getPrice()+" "+dto.getQty()+" "+dto.getCategories());
	        req.setAttribute("pDTO",dto);
	        //forward to result.jsp
	        rd=req.getRequestDispatcher("/result.jsp");
	        rd.forward(req, res);
	      }//try
	      catch(Exception e) {
	    	  e.printStackTrace();
	    	  System.out.println("hello");
	    	  rd=req.getRequestDispatcher("/error.jsp");
		        rd.forward(req, res);
	      }
  }//doPost
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}//doGet
}