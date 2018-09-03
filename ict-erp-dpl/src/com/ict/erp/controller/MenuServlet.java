package com.ict.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.common.ICTUtils;
import com.ict.erp.service.MenuService;
import com.ict.erp.service.impl.MenuServiceImpl;
import com.ict.erp.vo.MenuInfo;

public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String uri;
    private MenuService ms = new MenuServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		try {
			if(cmd.equals("menuList")) {
				if(request.getParameterMap().isEmpty()) {
					System.out.println("파람 없음");
				}
				request.setAttribute("menuList", ms.selectMenuList(null));
				doService(request,response); 
			}else if(cmd.equals("menuView")) {
				String meiNumStr = request.getParameter("meiNum");
				if(meiNumStr==null || meiNumStr.equals("")) {
					throw new SQLException("메뉴번호가 없잖아!!");
				}
				MenuInfo menu = new MenuInfo();
				menu.setMeiNum(Long.parseLong(meiNumStr));
				pw.println(ms.selectMenu(menu));
			}
		}catch(SQLException e) {
			pw.print("야 에러 났어!");
			pw.print("에러 이유는 : " + e);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		request.setCharacterEncoding("utf-8");
		try {
			if(cmd.equals("menuInsert")) {
				String meiName = request.getParameter("meiName");
				String meiPrice = request.getParameter("meiPrice");
				String meiDesc = request.getParameter("meiDesc");
				MenuInfo menu = new MenuInfo(null, meiName, Long.parseLong(meiPrice),meiDesc);
				pw.println(ms.insertMenu(menu));
			}else if(cmd.equals("menuUpdate")) {
				
			}else if(cmd.equals("menuDelete")) {
				
			}
		}catch(SQLException e) {
			pw.print("야 에러 났어!");
			pw.print("에러 이유는 : " + e);
		}
	}
	
	private void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views" + uri);
		rd.forward(request, response);
	}
	
}
