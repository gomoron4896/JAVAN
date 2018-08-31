package com.ict.music.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ict.music.common.DBcon;
import com.ict.music.dao.CommonDAO;
import com.ict.music.vo.FavInfo;

public class CommonDAOImpl implements CommonDAO {

	protected String sql;
	protected List<FavInfo> fiList; 
	protected Connection con;
	protected PreparedStatement ps;
	protected ResultSet rs;

	@Override
	public void setCon() {
		this.con = DBcon.getCon();
	}

	@Override
	public void closeSQL() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				DBcon.closeCon();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
