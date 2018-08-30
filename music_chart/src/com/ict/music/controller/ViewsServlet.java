package com.ict.music.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.music.common.OwnUtils;

@WebServlet("/ViewsServlet")
public class ViewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String uri; 

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		uri = req.getRequestURI();
		doService(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		uri = req.getRequestURI();
		doService(req, res);
	}
	
	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		uri = OwnUtils.getJSPPage(uri);
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}

}
