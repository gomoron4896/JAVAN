package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.DepartDAO;
import com.ict.erp.vo.DepartInfo;

public class DepartDAOImpl extends CommonDAOImpl implements DepartDAO {
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
		
		System.out.println(di.getPi().getlNum());
		System.out.println(di.getPi().getsNum());
		String sql = "select * from (";
		sql += "select di.*, rownum as rNum from (";
		sql += "select * from depart_info order by diNum desc) di";
		sql += " where rownum<=?)";
		sql += " where rNum>=?";
		System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, di.getPi().getlNum()+"");
		ps.setString(2, di.getPi().getsNum()+"");
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
	public int insertDepartInfo(DepartInfo di) throws SQLException {
		con = DBCon.getCon();
		String sql = "insert into Depart_info values(sqe_diNum.nextval,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, di.getDiCode());
		ps.setString(2, di.getDiName());
		ps.setString(3, di.getDiDesc());
		int cnt = ps.executeUpdate();
		con.commit();
		ps.close();
		System.out.println(cnt);
		return cnt;
	}

	@Override
	public int updateDepartInfo(DepartInfo di) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDepartInfo(DepartInfo di) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
