package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ict.erp.vo.LvlInfo;

public interface LvlService {
	public List<LvlInfo> getLiList(HttpServletRequest req) throws SQLException;

}
