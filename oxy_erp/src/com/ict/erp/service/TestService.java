package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.TestInfo;

public interface TestService {
	public List<TestInfo> getTiList(TestInfo ti) throws SQLException;
	public TestInfo getTestInfo(int tiNum) throws SQLException;

}
