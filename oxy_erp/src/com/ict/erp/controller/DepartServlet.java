package com.ict.erp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.common.DBCon;
import com.ict.erp.service.DepartService;
import com.ict.erp.service.impl.DepartServiceImpl;
import com.ict.erp.utils.ICTUtils;
import com.ict.erp.vo.DepartInfo;

@WebServlet(urlPatterns = "/depart/*", name = "DepartServlet", loadOnStartup = 1)
public class DepartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DepartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		DepartInfo di = null;
		DepartService ds = new DepartServiceImpl();
		try {
			if (cmd.equals("departList")) {
				req.setAttribute("diList", ds.getDepartInfoList(di));
				uri = "/views/depart/departList";
			} else if (cmd.equals("depart")) {
				return;
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCon.closeCon();
		}
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req, res);
	}

	public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = "/views" + req.getRequestURI();
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}

}
