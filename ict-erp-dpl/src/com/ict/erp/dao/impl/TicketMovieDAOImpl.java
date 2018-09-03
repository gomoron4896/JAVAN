package com.ict.erp.dao.impl;

import java.sql.SQLException;
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
			List<TicketMovie> tmList = IBean.convertList(rs, tm.getClass());
			System.out.println(tmList);
			return tmList;
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
		try {
			String sql = "insert into ticket_movie(tmNum, tmName, tmPrice, tmStartDat, tmEndDat, tmCredat, tmDesc, tmCnt, tmImg)";
			sql += "values(seq_tmNum.nextval,?,?,?,?,to_char(SYSDATE,'YYYYMMDD'),?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, tm.getTmName());
			ps.setInt(2, tm.getTmPrice());
			ps.setString(3, tm.getTmStartdat().replaceAll("-", ""));
			ps.setString(4, tm.getTmEnddat().replaceAll("-", ""));
			ps.setString(5, tm.getTmDesc());
			ps.setInt(6, tm.getTmCnt());
			ps.setString(7, tm.getTmImg());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
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
