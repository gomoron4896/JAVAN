package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.TestDAO;
import com.ict.erp.vo.TestInfo;

public class TestDAOImpl implements TestDAO {

	private Connection con = null;

	@Override
	public List<TestInfo> SelectTiList(TestInfo ti) throws SQLException {
		List<TestInfo> tiList = null;
		String sql = "select * from test_info";
		System.out.println("DAO : " + ti);
		if (ti != null) {
			if (ti.getTiNum() != 0) {
				sql += " where tiNum=?";
			} else if (ti.getTiId() != null) {
				sql += " where tiId like '%' || ? || '%'";
			} else if (ti.getTiName() != null) {
				sql += " where tiName like '%' || ? || '%'";
			} else if (ti.getTiText() != null) {
				sql += " where tiText like '%' || ? || '%'";
			}
		}
		try {
			con = DBCon.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			if (ti != null) {
				if (ti.getTiNum() != 0) {
					ps.setInt(1, ti.getTiNum());
				} else if (ti.getTiId() != null) {
					ps.setString(1, ti.getTiId());
				} else if (ti.getTiName() != null) {
					ps.setString(1, ti.getTiName());
				} else if (ti.getTiText() != null) {
					ps.setString(1, ti.getTiText());
				}
			}
			ResultSet rs = ps.executeQuery();
			tiList = new ArrayList<TestInfo>();
			while (rs.next()) {
				tiList.add(new TestInfo(rs.getInt("tiNum"), rs.getString("tiName"), rs.getString("tiText"),
						rs.getString("tiId")));
			}
		} catch (

		SQLException e) {
			throw e;
		} finally {
			DBCon.closeCon();
		}
		return tiList;
	}

	@Override
	public TestInfo SelectTestInfo(int tiNum) throws SQLException {
		TestInfo testInfo = null;
		String sql = "select * from test_info where tiNum=?";
		System.out.println("DAO : " + tiNum);
		try {
			con = DBCon.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, tiNum);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				testInfo = new TestInfo(rs.getInt("tiNum"), rs.getString("tiName"), rs.getString("tiText"),
						rs.getString("tiId"));
			}
		} catch (

		SQLException e) {
			throw e;
		} finally {
			DBCon.closeCon();
		}
		return testInfo;
	}
}
