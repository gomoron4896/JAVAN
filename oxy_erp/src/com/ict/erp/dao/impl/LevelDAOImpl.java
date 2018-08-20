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

	@Override
	public List<LevelInfo> SelectLiList(LevelInfo li) throws SQLException {
		Connection con = DBCon.getCon();
		String sql = "select lvl,liName,liDesc from lvl_info";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<LevelInfo> liList = new ArrayList<LevelInfo>();
		while(rs.next()) {
			li = new LevelInfo(rs.getInt("lvl"), rs.getString("liName"),rs.getString("liDesc"));
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

}
