package com.ict.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.service.UserService;
import com.ict.erp.service.impl.UserServiceImpl;
import com.ict.erp.utils.MenuUtils;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String rPath = request.getContextPath();
		String command = MenuUtils.getCommand(uri);

		PrintWriter out = response.getWriter();
		String url = "/erp";
		if (command.equals("login")) {
			us.login(request);
			Map<String, String> rMap = (Map<String, String>) request.getAttribute("rMap");
			url += rMap.get("url");
		} else if (command.equals("signup")) {

		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
