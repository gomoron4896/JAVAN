package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.LevelDAO;
import com.ict.erp.vo.LevelInfo;

public class LevelDAOImpl implements LevelDAO {
	
	private Connection con = null;
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	@Override
	public List<LevelInfo> SelectLiList(LevelInfo li) throws SQLException {
		Connection con = DBCon.getCon();
		String sql = "select liNum, liLevel, liName, liDesc from level_info";
		if (li != null) {
			if (li.getLiNum() != 0) {
				sql += " where liNum=?";
			} else if (li.getLiLevel() != 0) {
				sql += " where liLevel like '%' || ? || '%'";
			} else if (li.getLiName() != null) {
				sql += " where liName like '%' || ? || '%'";
			} else if (li.getLiDesc() != null) {
				sql += " where liDesc like '%' || ? || '%'";
			}
		}
		System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql);
		if (li != null) {
			if (li.getLiNum() != 0) {
				ps.setInt(1, li.getLiNum());
			} else if (li.getLiLevel() != 0) {
				ps.setInt(1, li.getLiLevel());
			} else if (li.getLiName() != null) {
				ps.setString(1, li.getLiName());
			} else if (li.getLiDesc() != null) {
				ps.setString(1, li.getLiDesc());
			}
		}
		ResultSet rs = ps.executeQuery();
		List<LevelInfo> liList = new ArrayList<LevelInfo>();
		while(rs.next()) {
			li = new LevelInfo(rs.getInt("liNum"), rs.getInt("liLevel"), rs.getString("liName"),rs.getString("liDesc"));
			liList.add(li);
		}
		DBCon.closeCon();
		return liList;
	}
	
	public static void main(String[] args) {
		LevelDAO ld = new LevelDAOImpl();
		try {
			System.out.println(ld.SelectLiList(null));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int insertLiList(List<LevelInfo> iList) throws SQLException {
		String sql = "insert into level_info (liNum,liLevel,liName,liDesc)";
		sql += "values(seq_liNum.nextval,?,?,?)";
		PreparedStatement ps = this.con.prepareStatement(sql);
		int cnt = 0;
		for(LevelInfo li : iList) {
		ps.setString(1, li.getLiLevel()+"");
		ps.setString(2, li.getLiName());
		ps.setString(3, li.getLiDesc());
		cnt += ps.executeUpdate();
		}
		return cnt;
	}

	@Override
	public int deleteLiList(String[] dNums) throws SQLException {
		String sql = "delete from level_info where liNum=?";
		PreparedStatement ps = this.con.prepareStatement(sql);
		int cnt = 0;
		for(String dNum : dNums) {
		ps.setString(1, dNum);
		cnt += ps.executeUpdate();
		}
		return cnt;
	}

	@Override
	public int updateLiList(List<LevelInfo> liList) throws SQLException {
		String sql = "update level_info";
		sql += "set liLevel=?,";
		sql += "liName=?,";
		sql += "liDesc=?";
		sql += "where liNum=?";
		PreparedStatement ps = this.con.prepareStatement(sql);
		int cnt = 0;
		return 0;
	}

}
