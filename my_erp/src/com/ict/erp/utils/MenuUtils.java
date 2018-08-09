package com.ict.erp.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ict.erp.vo.Menu;

public class MenuUtils {
	private static List<Menu> menuList;

	public static List<Menu> getMenuList(Object login) {
		menuList = new ArrayList<Menu>();
		Menu m = new Menu("/views/user/index.jsp", "home", "Home");
		menuList.add(m);

		if (login != null) {
			m = new Menu("/views/user/logout.jsp", "logout", "LogOut");
			menuList.add(m);
		} else {
			m = new Menu("/views/user/login.jsp", "login", "Login");
			menuList.add(m);
		}

		m = new Menu("/views/user/signup.jsp", "signup", "SignUp");
		menuList.add(m);
		
		if (login != null) {
			m = new Menu("/views/user/userlist.jsp", "List", "List");
			menuList.add(m);
		}
		return menuList;
	}

	public static String getCommand(String uri) {
		return uri.substring(uri.lastIndexOf("/") + 1);
	}
}