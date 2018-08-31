package com.ict.music.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBcon {
	
	private static Connection con;
	
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;

	public static void readyProp(String path) {
		InputStream is = DBcon.class.getResourceAsStream(path);
		Properties prop = new Properties();
		try {
			prop.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		pwd = prop.getProperty("pwd");
	}

	public static void openCon() {
		readyProp("/config/db.properties");
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			con.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		try {
			if(con==null || con.isClosed()) {
				openCon();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeCon() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Connection con = getCon();
		System.out.println(con!=null);
		closeCon();
	}
}
