package com.ict.erp.utils;

import javax.servlet.http.HttpServletRequest;

public class ICTUtils {
	public static String getCmd(String uri) {
		int idx = uri.lastIndexOf("/");
		if(idx==-1) {
			return null;
		}
		return uri.substring(idx+1);
	}

}
