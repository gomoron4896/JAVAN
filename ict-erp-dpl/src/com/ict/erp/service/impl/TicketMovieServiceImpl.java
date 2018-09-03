package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.TicketMovieDAO;
import com.ict.erp.dao.impl.TicketMovieDAOImpl;
import com.ict.erp.service.TicketMovieService;
import com.ict.erp.vo.TicketMovie;

public class TicketMovieServiceImpl implements TicketMovieService {
	TicketMovieDAO tmdao = new TicketMovieDAOImpl();

	@Override
	public List<TicketMovie> getTmList() throws SQLException {
		try {
			tmdao.setConnection(DBCon.getCon());
			return tmdao.selectTmList();
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}
	}

	@Override
	public TicketMovie getTm(TicketMovie tm) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> instTm(TicketMovie tm) throws SQLException {
		try {
			tmdao.setConnection(DBCon.getCon());
			Map<String, Object> rMap = new HashMap<String, Object>();
			rMap.put("cnt", tmdao.insertTm(tm));
			if ((Integer) rMap.get("cnt") == 1) {
				rMap.put("msg", "입력 성공");
			} else {
				rMap.put("msg", "입력 실패");
			}
			return rMap;
		} catch (SQLException e) {
			throw e;
		} finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> modifyTm(TicketMovie tm) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> removeTm(TicketMovie tm) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
