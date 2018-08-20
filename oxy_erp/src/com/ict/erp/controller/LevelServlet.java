package com.ict.erp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.service.LevelService;
import com.ict.erp.service.impl.LevelServiceImpl;
import com.ict.erp.utils.ICTUtils;
import com.ict.erp.vo.LevelInfo;

@WebServlet("/LevelServlet")
public class LevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LevelService ls = new LevelServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		System.out.println("WE ARE IN [" + this.getClass().getName() + "] [" + uri + "] & [" + cmd + "]");
		try {
			if (cmd == null || cmd.equals("")) {
				uri = "/views/notFound";
			} else if (cmd.equals("levelList")) {
				List<LevelInfo> liList = ls.getLiList(null);
				req.setAttribute("liList", liList);
				uri = "/views/level/levelList";

			} else {
				uri = "/views/notFound";
			}
		} catch (Exception e) {
			req.setAttribute("error", e.getMessage());
			uri = "/views/error";
		}
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
