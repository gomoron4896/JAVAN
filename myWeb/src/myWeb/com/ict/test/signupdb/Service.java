package myWeb.com.ict.test.signupdb;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {

	Connection con;

	List<Map<String, String>> uList = new ArrayList<Map<String, String>>();

	public List<Map<String, String>> getUserList() {
		this.con = DBCon.getCon();

		String sql = "select uiNum, uiName, uiId, uiPwd from user_info";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			Map<String, String> user;

			while (rs.next()) {
				user = new HashMap<String, String>();
				user.put("name", rs.getString("uiName"));
				user.put("id", rs.getString("uiId"));
				user.put("pwd", rs.getString("uiPwd"));
				uList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.closeCon();
		}
		return uList;
	}

	public List<Map<String, String>> getUserList(String[] ch, String s) {
		List<Map<String, String>> uList = new ArrayList<Map<String, String>>();
		this.con = DBCon.getCon();

		if(ch==null || s.trim().length() ==0) {
			return getUserList();
		}

		try {
			for (int i = 0; i < ch.length; i++) {
				String c = ch[i];
				
				String sql = "select uiNum, uiName, uiId, uiPwd from user_Info where " + c +" like '%' || ? || '%'";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, s);

				ResultSet rs = ps.executeQuery();
				Map<String, String> user;

				while (rs.next()) {
					user = new HashMap<String, String>();
					user.put("name", rs.getString("uiName"));
					user.put("id", rs.getString("uiId"));
					user.put("pwd", rs.getString("uiPwd"));
					if (uList.indexOf(user) == -1) {
						uList.add(user);
					}
				}

			}

			return uList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.closeCon();
		}

		return uList;

	}

	public int signup(String name, String id, String pwd) {
		this.con = DBCon.getCon();
		int result;

		String sql = "insert into user_info values (uino_seq.nextval, ?, ?, ?)";

		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, id);
			ps.setString(3, pwd);

			result = ps.executeUpdate();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.closeCon();
		}
		return -1;

	}

}