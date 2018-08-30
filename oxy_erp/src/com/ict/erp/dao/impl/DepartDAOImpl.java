package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.DepartDAO;
import com.ict.erp.vo.DepartInfo;

public class DepartDAOImpl implements DepartDAO {
	private Connection con = null;

	public void setConnection(Connection con) {
		this.con = con;
	}

	@Override
	public List<DepartInfo> selectDepartInfoList(DepartInfo di) throws SQLException {
		con = DBCon.getCon();
		if(di!=null) {
			
		} else {
		}
		List<DepartInfo> diList = new ArrayList<DepartInfo>();
		String sql = "select * from Depart_info";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			di = new DepartInfo();
			di.setDiNum(rs.getInt("diNum"));
			di.setDiCode(rs.getString("diCode"));
			di.setDiName(rs.getString("diName"));
			di.setDiDesc(rs.getString("diDesc"));
			diList.add(di);
		}
		rs.close();
		ps.close();
		return diList;
	}

	@Override
	public DepartInfo selectDepartInfo(int diNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> insertDepartInfo(DepartInfo di) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateDepartInfo(DepartInfo di) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteDepartInfo(DepartInfo di) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
