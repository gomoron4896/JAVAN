package com.own.batch.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import batch_address.DBCon;

public class BatchDAOImpl {

	public int insert(List<List<String>> list) {
		Long stime = System.currentTimeMillis();

		Connection con = DBCon.getCon();

		int cnt = 0;
		String sql = "insert into addr_list";
		sql += " values(seq_alNum.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			int addCnt = 0;
			PreparedStatement ps = con.prepareStatement(sql);
			for (List<String> li : list) {
				for (int i = 1, j = 0, max = 12; i <= max; i++, j++) {
					if (j == 10) {
						j++;
					}
					ps.setString(i, li.get(j));
				}
				ps.addBatch();
				addCnt++;
				ps.clearParameters();
				if (addCnt + 1 % 100 == 1 || list.size() / addCnt == 1) {
					cnt += ps.executeBatch().length;
				}
			}
			DBCon.close();
			Long eTime = System.currentTimeMillis();
			System.out.println("걸린 시간 - " + (eTime - stime));
			return cnt;
		} catch (SQLException e) {
			DBCon.rollback();
			e.printStackTrace();
		} finally {
			DBCon.close();
		}
		Long eTime = System.currentTimeMillis();
		System.out.println("걸린 시간 - " + (eTime - stime));

		return cnt;
	}
}
