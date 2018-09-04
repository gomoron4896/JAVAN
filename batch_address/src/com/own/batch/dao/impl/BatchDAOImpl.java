package com.own.batch.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import batch_address.DBCon;

public class BatchDAOImpl {

	public int insert(List<List<String>> list) {
		Connection con = DBCon.getCon();
		
		int cnt = 0;
		String sql = "insert into addr_list";
		sql += " values(" + "seq_alNum.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			for (List<String> li : list) {
				for (int i = 1, j = 0, max = 12; i <= max; i++, j++) {
					if (j == 10) {
						j++;
					}
					ps.setString(i, li.get(j));
				}
				ps.addBatch();
				ps.clearParameters();
			}
			cnt = ps.executeBatch().length;
			DBCon.close();
			return cnt; 
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				DBCon.rollback();
				e.printStackTrace();
			} finally {
				DBCon.close();
			}
			return cnt;
		}
	}
}
