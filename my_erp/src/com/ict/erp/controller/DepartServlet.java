package com.ict.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.common.DBCon;
import com.ict.erp.service.DepartService;
import com.ict.erp.service.impl.DepartServiceImpl;
import com.ict.erp.utils.ICTUtils;
import com.ict.erp.vo.DepartInfo;

public class DepartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartService ds = new DepartServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String rPath = request.getContextPath();
		String cmd = ICTUtils.getCmd(uri);
		uri = "/views" + uri.replace(rPath, "") + ".jsp";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (cmd == null || cmd.equals("")) {
			pw.println("WRONG ACCESS");
			return;
		}
		try {
			if(cmd.equals("list")) {
			List<DepartInfo> diList = ds.getDepartList();
			request.setAttribute("diList", diList);
			RequestDispatcher rd = request.getRequestDispatcher(uri);
			rd.forward(request, response);
			} else if (cmd.equals("view")) {
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public static void main(String[] args) {
		DepartServlet ds = new DepartServlet();
		try {
			ds.doGet(null, null);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
