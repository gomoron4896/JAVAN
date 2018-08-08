package com.ict.erp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;

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
		} finally {
			
		}
		return memInfo;

	}
	
	public static int checkInfo(String id) {
		if (DBcon.con == null) {
			openCon();
		}
		int cnt = 0;
//		String sql = "select * from member_info where miId='" + id +"'AND miPwd='" + pwd + "'";
		String sql = "select count(1) from member_info where miId=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
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
		int cnt = 0;
//		String sql = "select * from member_info where miId='" + id +"'AND miPwd='" + pwd + "'";
		String sql = "select * from member_info where miId=? AND miPwd=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		return cnt;

	}
	
//	insert into member_info
//	values(seq_mino.nextval,'admin','qwe!@#',1,'oxym4896@gmail.com','관리자',to_char(sysdate,'YYYYMMDD'),to_char(sysdate,'HH24miss'),1,
//	to_char(sysdate,'YYYYMMDD'),to_char(sysdate,'HH24miss'),1,3,'김기섭');
	public static void main(String[] args) {
		int cnt = DBcon.checkInfo("admin");
		System.out.println(cnt);
			
		}
	}
