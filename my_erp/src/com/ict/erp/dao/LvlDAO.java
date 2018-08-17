package com.ict.erp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.LvlInfo;

public interface LvlDAO {
		public List<LvlInfo> selectLvlList(Connection con) throws SQLException;

}
