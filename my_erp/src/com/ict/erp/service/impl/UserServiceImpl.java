package com.ict.erp.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ict.erp.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void login(HttpServletRequest req) {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("msg", "SUCCESS");
		rMap.put("url", "views/index");
		req.setAttribute("rMap", rMap);
		if(id.equals("oxym4896")) {
			if(pwd.equals("@rltjq4896")) {
				return;
			}
		}
		
		rMap.put("msg", "FAILED");
		rMap.put("url", "views/user/login");
		
	}

}
