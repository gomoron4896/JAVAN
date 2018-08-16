package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.DepartDAO;
import com.ict.erp.vo.DepartInfo;

public class DepartDAOImpl implements DepartDAO {
	private Connection con;
	
	public DepartDAOImpl() {
	}	

	public DepartDAOImpl(Connection con) {
		this.con = DBCon.getCon();
	}

	@Override
	public List<DepartInfo> selectDepartList(Connection thisCon) throws SQLException {
		List<DepartInfo> ls = new ArrayList<DepartInfo>();
		String sql = "select diNo, diName, diDesc, diCnt from depart_info";
		PreparedStatement ps = thisCon.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			DepartInfo di = new DepartInfo();
			di.setDiNo(rs.getInt("diNo"));
			di.setDiName(rs.getString("diName"));
			di.setDiDesc(rs.getString("diDesc"));
			di.setDiCnt(rs.getInt("diCnt"));
			ls.add(di);
		}
		rs.close();
		ps.close();
		return ls;
	}

	@Override
	public DepartInfo selectDepart() {

		return null;
	}

	public static void main(String[] args) {

	}

}
