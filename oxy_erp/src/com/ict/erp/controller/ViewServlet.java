package com.ict.erp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ict.erp.utils.ICTUtils;

@WebServlet("/viewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String rPath = req.getContextPath();
		String uri = req.getRequestURI();
		uri = uri.replaceFirst(rPath, "");
		String cmd = ICTUtils.getCmd(uri);
		String page = null;
		System.out.println("WE ARE IN [" + this.getClass().getName() + "] [" + uri + "] & [" + cmd + "]\r\n");

		if (cmd == null || cmd.equals("")) {
			page = ICTUtils.getJSPpage("/views/index");
		} else if (cmd.equals("levelList")) {
			page = ICTUtils.getJSPpage("/views/level/levelList");
		} else if (cmd.equals("error")) {
			page = ICTUtils.getJSPpage("/views/error");
		} else {
			page = ICTUtils.getJSPpage(uri);
		}
		RequestDispatcher rd = req.getRequestDispatcher(page);
		rd.forward(req, res);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
