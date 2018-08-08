package com.ict.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String rPath = req.getContextPath();
		
		uri = uri.replace(rPath, "");
		uri = "/WEB-INF" + uri + ".jsp";
		
		System.out.println(uri);
		
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
		
//		res.setContentType("text/html;charset=UTF-8");
//		res.setCharacterEncoding("UTF-8");
//		PrintWriter out = res.getWriter();
//		out.println("DID U CALL ME?<br>");
//		out.println("I'M TEXT");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
