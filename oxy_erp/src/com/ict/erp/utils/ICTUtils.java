package com.ict.erp.utils;

import javax.servlet.http.HttpServletRequest;

public class ICTUtils {
	private static final String PRE_FIX = "/WEB-INF";
	private static final String SUF_FIX = ".jsp";
	private static final String SEP_STR = "/";
	public static String getCmd(String uri) {
		int idx = uri.lastIndexOf(SEP_STR);
		if(idx==-1) {
			return null;
		}
		return uri.substring(idx+1);
	}
	
	public static String getJSPpage(String uri) {
		return PRE_FIX + uri + SUF_FIX;
	}
	
	public static void main(String[] args ) {
	}

}
