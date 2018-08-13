package com.ict.erp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.DepartInfo;

public interface DepartService {
	public List<DepartInfo> getDepartList(Connection thisCon) throws SQLException;
	public DepartInfo getDepart();

}
