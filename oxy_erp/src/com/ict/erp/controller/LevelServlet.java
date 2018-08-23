package com.ict.erp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ict.erp.vo.TestInfo;

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
				LevelInfo li = null;
				List<LevelInfo> liList = null;
				String shType = req.getParameter("shType");
				String shText = req.getParameter("shText");
				if(shText!=null) {
					li = new LevelInfo();
					if(shType.equals("liNum")) {
						li.setLiNum(Integer.parseInt(shText));
					} else if(shType.equals("liLevel")) {
						li.setLiLevel(Integer.parseInt(shText));;
					} else if(shType.equals("liName")) {
						li.setLiName(shText);;
					} else if(shType.equals("liDesc")) {
						li.setLiDesc(shText);
					}
				}
				System.out.println("나는 검색할 놈" + li);
				liList = ls.getLiList(li);
				req.setAttribute("liList", liList);
				uri = "/views/level/levelList";

			} else if (cmd.equals("saveLevelList")) {
				List<LevelInfo> iList = new ArrayList<LevelInfo>();
				String[] liNames = req.getParameterValues("liName");
				String[] liLevels = req.getParameterValues("liLevel");
				String[] liDesces = req.getParameterValues("liDesc");
				for (int i = 0; i < liNames.length; i++) {
					int level = Integer.parseInt(liLevels[i]);
					LevelInfo li = new LevelInfo(0, level, liNames[i], liDesces[i]);
					iList.add(li);
				}
				Map<String, List<LevelInfo>> map = new HashMap<String, List<LevelInfo>>();
				map.put("iList", iList);
				map.put("uList", new ArrayList<LevelInfo>());
				Map<String, Object> rMap = ls.insertNUpdateLilist(map);
				req.setAttribute("rMap", rMap);
				uri = "/views/level/levelList";
			} else if (cmd.equals("deleteLevelList")) {
				String[] dNums = req.getParameterValues("liNum");
				Map<String, Object> rMap = ls.deleteLilist(dNums);
				req.setAttribute("rMap", rMap);
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
