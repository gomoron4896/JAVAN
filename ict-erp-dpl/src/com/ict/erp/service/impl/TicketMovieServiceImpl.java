package com.ict.erp.service.impl;

import java.sql.SQLException;
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
		} catch(SQLException e) {
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
		// TODO Auto-generated method stub
		return null;
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
