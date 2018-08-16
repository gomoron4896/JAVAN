package com.ict.erp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.DepartDAO;
import com.ict.erp.dao.impl.DepartDAOImpl;
import com.ict.erp.service.DepartService;
import com.ict.erp.vo.DepartInfo;

public class DepartServiceImpl implements DepartService {

	@Override
	public List<DepartInfo> getDepartList() throws SQLException {
		DepartDAO ddao = new DepartDAOImpl();
		List<DepartInfo> ls = null;
		try {
			ls = ddao.selectDepartList(DBCon.getCon());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCon.closeCon();
		}
		return ls;
	}

	@Override
	public DepartInfo getDepart() {
		
		return null;
	}

}
