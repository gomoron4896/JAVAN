package com.ict.erp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DBcon {
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String id = "system";
	private static String pwd = "12345678";
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static Connection con;

	// Connection 관련 메서드
	public static void openCon() {
		try {
			if (DBcon.con == null || DBcon.con.isClosed()) {
				try {
					Class.forName(driver);
					DBcon.con = DriverManager.getConnection(url, id, pwd);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		if (DBcon.con == null) {
			openCon();
		}
		return DBcon.con;
	}

	public static boolean closeCon() {
		if (DBcon.con != null) {
			try {
				DBcon.con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		return false;

	}

	// SQL 메서드
	public static HashMap<String, String> getInfo(String id, String pwd) {
		if (DBcon.con == null) {
			openCon();
		}
		try {
			if (DBcon.con.isClosed()) {
				DBcon.con = null;
				DBcon.openCon();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HashMap<String, String> memInfo = new HashMap<String, String>();
		// String sql = "select * from member_info where miId='" + id +"'AND miPwd='" +
		// pwd + "'";
		String sql = "select * from member_info where miId=? AND miPwd=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				memInfo.put("miName", rs.getString("miName"));
				memInfo.put("miEail", rs.getString("miEmail"));
				memInfo.put("miId", rs.getString("miId"));
				memInfo.put("diNo", rs.getString("diNo"));
				memInfo.put("miNo", rs.getString("miNo"));
				memInfo.put("lvl", rs.getString("lvl"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBcon.closeCon();
		}
		return memInfo;

	}

	public static int checkInfo(String id) {
		if (DBcon.con == null) {
			openCon();
		}
		try {
			if (DBcon.con.isClosed()) {
				DBcon.con = null;
				DBcon.openCon();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int cnt = 0;
		// String sql = "select * from member_info where miId='" + id +"'AND miPwd='" +
		// pwd + "'";
		String sql = "select count(1) from member_info where miId=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBcon.closeCon();
		}
		return cnt;

	}

	public static int instInfo(HashMap<String, String> infoMap) {
		if (DBcon.con == null) {
			openCon();
		}
		try {
			if (DBcon.con.isClosed()) {
				DBcon.con = null;
				DBcon.openCon();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int cnt = 0;
		// String sql = "select * from member_info where miId='" + id +"'AND miPwd='" +
		// pwd + "'";
		String sql = "insert into member_info values(seq_mino.nextval,?,?,1,?,?,to_char(sysdate,'YYYYMMDD'),to_char(sysdate,'HH24miss'),?,to_char(sysdate,'YYYYMMDD'),to_char(sysdate,'HH24miss'),?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, infoMap.get("miId"));
			ps.setString(2, infoMap.get("miPwd"));
			ps.setString(3, infoMap.get("miEmail"));
			ps.setString(4, infoMap.get("miEtc"));
			ps.setString(5, infoMap.get("miNo"));
			ps.setString(6, infoMap.get("miNo"));
			ps.setString(7, infoMap.get("lvl"));
			ps.setString(8, infoMap.get("miName"));
			cnt = ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBcon.closeCon();
		}
		return cnt;
	}

	public static ArrayList<HashMap<String, String>> getList() {
		if (DBcon.con == null) {
			openCon();
		}
		try {
			if (DBcon.con.isClosed()) {
				DBcon.con = null;
				DBcon.openCon();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<HashMap<String, String>> memList = new ArrayList<HashMap<String, String>>();
		// String sql = "select * from member_info where miId='" + id +"'AND miPwd='" +
		// pwd + "'";
		String sql = "select * from member_info";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HashMap<String, String> hm = new HashMap<String, String>();
				hm.put("miName", rs.getString("miName"));
				hm.put("miEail", rs.getString("miEmail"));
				hm.put("miId", rs.getString("miId"));
				hm.put("diNo", rs.getString("diNo"));
				hm.put("miNo", rs.getString("miNo"));
				hm.put("lvl", rs.getString("lvl"));
				memList.add(hm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBcon.closeCon();
		}
		return memList;

	}

	public static void main(String[] args) {
		int cnt = DBcon.checkInfo("admin");
		System.out.println(cnt);

	}
}
