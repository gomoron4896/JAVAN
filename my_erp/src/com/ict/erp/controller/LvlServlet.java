package com.ict.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.service.LvlService;
import com.ict.erp.service.impl.LvlServiceImpl;
import com.ict.erp.utils.ICTUtils;

public class LvlServlet extends HttpServlet {
	
	private LvlService ls = new LvlServiceImpl();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException{
		
		String uri = req.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		
		if(cmd==null || cmd.trim().equals("")) {
			doService(res,"SOMETHING WRONG");
			return;
		}
		
		String rPath = req.getContextPath();
		uri = uri.replaceFirst(rPath, "");
		String page = ICTUtils.getJSPpage(uri);
		
		if(cmd.equals("lvlList")) {
			try {
				ls.getLiList(req);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher(page);
		rd.forward(req, res);
	}
	

	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		
		doService(res,null);
	}
	
	public void doService(HttpServletResponse res, String txt) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.print("옼돜");
	}
}
