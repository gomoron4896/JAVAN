package com.ict.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Map<String, String[]> reqMap = request.getParameterMap();
		Iterator<String> it = reqMap.keySet().iterator();
		while (it.hasNext()) {
			String name = it.next();
			String[] values = reqMap.get(name);
			if (values[0].length() != 0) {
				out.println("YOUR " + name);
			}
			for (String value : values) {
				out.println(value + " ");
			}
			out.print("<br>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
