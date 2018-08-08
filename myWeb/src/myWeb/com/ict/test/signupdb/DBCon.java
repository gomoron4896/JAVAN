package myWeb.com.ict.test.signupdb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBCon {
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String id = "system";
	private static String pwd = "12345678";
	private static String driver = "oracle.jdbc.driver.OracleDriver";

	public static Connection con;
	
	public static Connection getCon() {
		if(DBCon.con == null) {
			openCon();
		}
		return DBCon.con;
		
	}
	
	private static void openCon() {
		try {
			Class.forName(driver);
			DBCon.con = DriverManager.getConnection(url, id, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void closeCon() {
		if(DBCon.con !=null) {
			try {
				DBCon.con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DBCon.con = null;
	}
	
	public static void main(String[] args) {
		openCon();
	}

}
