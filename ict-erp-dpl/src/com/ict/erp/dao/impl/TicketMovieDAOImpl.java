package com.ict.erp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.IBean;
import com.ict.erp.dao.TicketMovieDAO;
import com.ict.erp.vo.TicketMovie;

public class TicketMovieDAOImpl extends CommonDAOImpl implements TicketMovieDAO {

	@Override
	public List<TicketMovie> selectTmList() throws SQLException {
		try {
			String sql = "select * from ticket_movie";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			TicketMovie tm = new TicketMovie();
			return IBean.convertList(rs, tm.getClass());
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public TicketMovie selectTm(TicketMovie tm) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertTm(TicketMovie tm) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTm(TicketMovie tm) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTm(TicketMovie tm) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
