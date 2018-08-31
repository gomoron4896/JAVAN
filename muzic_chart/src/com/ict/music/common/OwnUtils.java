package com.ict.music.common;

import javax.servlet.http.HttpServletRequest;

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
	
	public static <T> void getLog(Class<T> clss, HttpServletRequest req) {
		String clazzName = clss.getName();
		String logHeader = clazzName.substring(clazzName.lastIndexOf(".") + 1);
		String uri = req.getRequestURI();
		String httpMethod = req.getMethod();
		boolean hasParam = !(req.getParameterMap().isEmpty());
		if (!(uri.lastIndexOf("/vendor") == 0)) {
			System.out.println("// " + httpMethod + ":" + logHeader + "  " + "[URI : " + uri + " & "
								+ "hasPARAM : " + hasParam + "]" + " - [REF : " + clazzName + " ]");
			if (logHeader.equals("ViewsServlet")) {
				System.out.println("// END OF SERVLET\r\n");
			}
		}
	}
	
	public static void main(String[] args) {
		
	}

}