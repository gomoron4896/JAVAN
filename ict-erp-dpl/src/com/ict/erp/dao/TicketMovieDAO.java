package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.TicketMovie;

public interface TicketMovieDAO  extends CommonDAO{
	public List<TicketMovie> selectTmList() throws SQLException;
	public TicketMovie selectTm(TicketMovie tm) throws SQLException;
	public int insertTm(TicketMovie tm) throws SQLException;
	public int updateTm(TicketMovie tm) throws SQLException;
	public int deleteTm(TicketMovie tm) throws SQLException;
}
