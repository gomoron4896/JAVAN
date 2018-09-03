package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.vo.TicketMovie;

public interface TicketMovieService {
	public List<TicketMovie> getTmList() throws SQLException;
	public TicketMovie getTm(TicketMovie tm) throws SQLException;
	public Map<String, Object> instTm(TicketMovie tm) throws SQLException;
	public Map<String, Object> modifyTm(TicketMovie tm) throws SQLException;
	public Map<String, Object> removeTm(TicketMovie tm) throws SQLException;

}
