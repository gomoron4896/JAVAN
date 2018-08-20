package com.ict.erp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.service.TestService;
import com.ict.erp.service.impl.TestServiceImpl;
import com.ict.erp.utils.ICTUtils;
import com.ict.erp.vo.TestInfo;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TestService ts = new TestServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		String page = null;
		TestInfo ti = null;
		System.out.println("WE ARE IN [" + this.getClass().getName() + "] [" + uri + "] & [" + cmd + "]");
		try {
			if (cmd == null || cmd.equals("")) {
				page = "/views/index";
			} else if (cmd.equals("testList")) {
				String shType = req.getParameter("shType");
				String shText = req.getParameter("shText");
				if(shText!=null) {
					ti = new TestInfo();
					if(shType.equals("tiNum")) {
						ti.setTiNum(Integer.parseInt(shText));
					} else if(shType.equals("tiName")) {
						ti.setTiName(shText);
					} else if(shType.equals("tiText")) {
						ti.setTiText(shText);
					} else if(shType.equals("tiId")) {
						ti.setTiId(shText);
					}
				}
				System.out.println("서블릿 : "+ti);
				req.setAttribute("tiList", ts.getTiList(ti));
				page = "/views/test/testList";
			} else if(cmd.equals("testView")) {
				req.setAttribute("testInfo", ts.getTestInfo(Integer.parseInt(req.getParameter("tiNum"))));
				page = "/views/test/testView";
			} else {
				page = "/views/notFound";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			req.setAttribute("error", e);
			page = "/views/error";
		}
		RequestDispatcher rd = req.getRequestDispatcher(page);
		rd.forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);
	}

}
