package com.ict.erp.utils;

import java.util.ArrayList;
import java.util.List;

import com.ict.erp.vo.Menu;

public class MenuUtils {
	private static List<Menu> menuList; 
			
	
	public static List<Menu> getMenuList(){
		if(menuList==null) {
			menuList = new ArrayList<Menu>();
			Menu m = new Menu("views/index.jsp","home","Home");
			menuList.add(m);
			m = new Menu("views/user/login.jsp","login","Login");
			menuList.add(m);
			m = new Menu("views/user/signup.jsp","signup","SingUp");
			menuList.add(m);
		}
		return menuList;
	}
	
	public static String getCommand(String uri) {
		return uri.substring(uri.lastIndexOf("/")+1);
	}
}