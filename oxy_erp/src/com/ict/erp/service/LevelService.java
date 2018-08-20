package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.LevelInfo;

public interface LevelService {
	public List<LevelInfo> getLiList(LevelInfo li) throws SQLException ; 

}
