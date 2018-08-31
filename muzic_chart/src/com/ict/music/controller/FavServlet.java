package com.ict.music.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
	private String cmd;
	private FavService fs;
	private FavInfo fi;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		OwnUtils.getLog(this.getClass(), req);
		req.setCharacterEncoding("UTF-8");
		uri = req.getRequestURI();
		cmd = OwnUtils.getCmd(uri);
		try {
			if (cmd.equals(null) || cmd.equals("")) {
				uri = "/errors/404";
			} else if (cmd.equals("favList")) {
				fi = null;
				fs = new FavServiceImpl();
				fs.getFiList(fi);
				req.setAttribute("fiList", fs.getFiList(fi));
			} else if (cmd.equals("favInsert")) {
				if (!req.getParameterMap().isEmpty()) {
					fi = new FavInfo();
					fi.setMcName(req.getParameter("mcName"));
					fi.setMcSinger(req.getParameter("mcSinger"));
					fi.setMcVendor(req.getParameter("mcVendor"));
					fi.setMcLike(Long.parseLong(req.getParameter("mcLike")));
					fi.setMcDisLike(Long.parseLong(req.getParameter("mcDisLike")));
					fi.setMcCreDat(req.getParameter("mcCreDat"));
					fi.setMcDesc(req.getParameter("mcDesc"));
					fs = new FavServiceImpl();
					req.setAttribute("insertResult", fs.addFavInfo(fi));
				}
			} else {
				uri = "/errors/404";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		doService(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		OwnUtils.getLog(this.getClass(), req);
		uri = req.getRequestURI();
		cmd = OwnUtils.getCmd(uri);
		try {
			if (cmd.equals("favDelete")) {
				Map<String, Object> deleteResult = null;
				String[] mcNumStrs = req.getParameterValues("mcNum");
				Long[] mcNumLongs = null;
				if (mcNumStrs.length != 0) {
					mcNumLongs = new Long[mcNumStrs.length];
					for (int i = 0; i < mcNumLongs.length; i++) {
						mcNumLongs[i] = Long.parseLong(mcNumStrs[i]);
					}
					fs = new FavServiceImpl();
					deleteResult = fs.removeFavInfo(mcNumLongs);
					req.setAttribute("deleteResult", deleteResult);
				} else {
					deleteResult = new HashMap<String, Object>();
					deleteResult.put("msg", "삭제할 값이 없습니다.");
					req.setAttribute("deleteResult", deleteResult);
				}
				uri = "/fav/favList";
				RequestDispatcher rd = req.getRequestDispatcher(uri);
				rd.forward(req, res);
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		doService(req, res);
	}

	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println(uri);
		uri = OwnUtils.getViewsURI(uri);
		System.out.println(uri);
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}

}
