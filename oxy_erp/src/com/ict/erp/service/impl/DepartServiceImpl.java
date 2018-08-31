package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.dao.DepartDAO;
import com.ict.erp.dao.impl.DepartDAOImpl;
import com.ict.erp.service.DepartService;
import com.ict.erp.vo.DepartInfo;
import com.ict.erp.vo.PageInfo;

public class DepartServiceImpl implements DepartService {

	private DepartDAO dDAO = new DepartDAOImpl();
	
	@Override
	public List<DepartInfo> getDepartInfoList(DepartInfo di) throws SQLException {
		PageInfo pi = di.getPi();
		pi.setTotalCnt(1006);
		pi.setlNum(pi.getPage()*10);
		pi.setsNum((pi.getPage()-1)*10+1);
		return dDAO.selectDepartInfoList(di);
	}

	@Override
	public DepartInfo getDepartInfo(int diNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> insertDepartInfo(DepartInfo di) throws SQLException {
		Map<String, Object> rMap = new HashMap<String, Object>();
		try {
			int cnt = dDAO.insertDepartInfo(di);
			rMap.put("cnt", cnt);
			rMap.put("msg", "실패");
			if(cnt==1) {
				rMap.put("msg", "실패");
			}
		} catch(SQLException e) {
			throw e;
		}
		return rMap;
	}

	@Override
	public Map<String, Object> updateDepartInfo(DepartInfo di) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteDepartInfo(DepartInfo di) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
