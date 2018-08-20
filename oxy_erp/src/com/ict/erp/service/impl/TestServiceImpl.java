package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.dao.TestDAO;
import com.ict.erp.dao.impl.TestDAOImpl;
import com.ict.erp.service.TestService;
import com.ict.erp.vo.TestInfo;

public class TestServiceImpl implements TestService {

	@Override
	public List<TestInfo> getTiList(TestInfo ti) throws SQLException {
		TestDAO td = new TestDAOImpl();
		System.out.println("서비스 : "+ti);
		return td.SelectTiList(ti);
	}

	@Override
	public TestInfo getTestInfo(int tiNum) throws SQLException {
		TestDAO td = new TestDAOImpl();
		System.out.println("서비스 : "+tiNum);
		return td.SelectTestInfo(tiNum);
	}

}
