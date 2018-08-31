package com.ict.music.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.music.common.OwnUtils;
import com.ict.music.service.FavService;
import com.ict.music.service.impl.FavServiceImpl;
import com.ict.music.vo.FavInfo;

/**
 * Servlet implementation class FavServlet
 */
public class FavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String uri;
	private FavService fs;
	private FavInfo fi;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		uri = req.getRequestURI();
		String cmd = OwnUtils.getCmd(uri);
		if(cmd.equals(null) || cmd.equals("")) {
			uri = "/errors/404";
		} else if(cmd.equals("favList")) {
			fi = new FavInfo();
			fs = new FavServiceImpl();
			fs.getFiList(fi);
			req.setAttribute("fiList", fs.getFiList(fi));
		} else {
			uri = "/errors/404";
		}
		doService(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doService(req,res);
	}
	
	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		uri = OwnUtils.getViewsURI(uri);
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}

}
