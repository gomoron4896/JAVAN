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
import com.ict.erp.vo.PageInfo;

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
		System.out.println("[" + this.getClass().getName() + "] - " + uri + " [doGet]");
		try {
			if (cmd.equals("departList")) {
				String pageStr = req.getParameter("page");
				if(pageStr==null || pageStr.equals("")) {
					pageStr = "1";
				}
				int page = Integer.parseInt(pageStr);
				di = new DepartInfo();
				PageInfo pi = new PageInfo();
				pi.setPage(page);
				di.setPi(pi);
				req.setAttribute("diList", ds.getDepartInfoList(di));
				uri = "/views/depart/departList";
			} else if (cmd.equals("depart")) {
				return;
			} else if(cmd.equals("departInsert")) { 
				doPost(req, res);
				return;
			} else {
				uri = "/views" + uri;
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
		String uri = req.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		DepartInfo di = null;
		DepartService ds = new DepartServiceImpl();
		System.out.println("[" + this.getClass().getName() + "] - " + uri + " [doPost]");
		try {
			System.out.println(req.getParameter("diCode"));
			if (cmd.equals("departList")) {
				if(req.getParameter("diCode")!=null) {
				String diCode = req.getParameter("diCode");
				String diName = req.getParameter("diName");
				String diDesc = req.getParameter("diDesc");
				di = new DepartInfo(0,diCode,diName,diDesc);
				req.setAttribute("diInst", ds.insertDepartInfo(di));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCon.closeCon();
		}
		
		doService(req, res);
	}

	public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = "/views" + req.getRequestURI();
		System.out.println("[" + this.getClass().getName() + "] - " + uri + " [doService]");
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}

}
