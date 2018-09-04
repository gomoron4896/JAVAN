package com.ict.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ict.erp.service.DepartService;
import com.ict.erp.service.TicketMovieService;
import com.ict.erp.service.impl.DepartServiceImpl;
import com.ict.erp.service.impl.TicketMovieServiceImpl;
import com.ict.erp.vo.DepartInfo;
import com.ict.erp.vo.TicketMovie;

public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Gson gs = new Gson();   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Map<String, String> pMap = gs.fromJson(request.getParameter("param"), Map.class);
		//System.out.println(pMap);
		response.setContentType("text/html;charset=utf-8");
		//response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		DepartService ds = new DepartServiceImpl();
		try {
			List<DepartInfo> diList = ds.getDepartInfoNonePageList(null);
			String resStr = gs.toJson(diList);
			System.out.println(resStr);
			pw.println(resStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		TicketMovieService tms = new TicketMovieServiceImpl();
		try {
			List<TicketMovie> tmList = tms.getTmList();
			pw.write(gs.toJson(tmList));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//doGet(request, response);
	}
	
	public static void main(String[] args) {
		String jsonStr = "[{\"a\":\"\1\"}]";
		Gson gs = new Gson();
		List<Map<String,String>> list = gs.fromJson(jsonStr, List.class);
		System.out.println(list);
	}

}
