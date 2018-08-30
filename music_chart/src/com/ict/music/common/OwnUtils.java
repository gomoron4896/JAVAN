package com.ict.music.common;

public class OwnUtils {
	private static final String PRE_FIX = "/WEB-INF";
	private static final String SUF_FIX = ".jsp";
	
	public static String getCmd(String uri) {
		int lastIdx = uri.lastIndexOf("/");
		return uri.substring(lastIdx+1);
	}
	
	public static String getJSPPage(String uri) {
		return PRE_FIX + uri + SUF_FIX;
	}
	
	public static String getViewsURI(String uri) {
		return "/views" + uri;
	}
	
	public static void main(String[] args) {
		
	}

}