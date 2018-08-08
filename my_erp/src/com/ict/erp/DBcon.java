package com.ict.erp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DBcon {
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String id = "system";
	private static String pwd = "12345678";
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static Connection con;

	public static void openCon() {
		if (DBcon.con == null) {
			try {
				Class.forName(driver);
				DBcon.con = DriverManager.getConnection(url, id, pwd);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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

	public static HashMap<String, String> getInfo(String id, String pwd) {
		if (DBcon.con == null) {
			openCon();
		}
		HashMap<String, String> memInfo = new HashMap<String, String>();
//		String sql = "select * from member_info where miId='" + id +"'AND miPwd='" + pwd + "'";
		String sql = "select * from member_info where miId=? AND miPwd=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				memInfo.put("name", rs.getString("miName"));
				memInfo.put("email", rs.getString("miEmail"));
				memInfo.put("id", rs.getString("miId"));
				memInfo.put("dino", rs.getString("diNo"));
				memInfo.put("miNo", rs.getString("miNo"));
				memInfo.put("lvl", rs.getString("lvl"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memInfo;

	}

	public static void main(String[] args) {
		HashMap<String,String> hm = DBcon.getInfo("admin", "qwe!@#");
		System.out.println(hm);
			
		}
	}
