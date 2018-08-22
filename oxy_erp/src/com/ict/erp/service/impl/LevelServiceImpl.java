package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.LevelDAO;
import com.ict.erp.dao.impl.LevelDAOImpl;
import com.ict.erp.service.LevelService;
import com.ict.erp.vo.LevelInfo;

public class LevelServiceImpl implements LevelService {
	private LevelDAO ldao = new LevelDAOImpl();
	
	@Override
	public List<LevelInfo> getLiList(LevelInfo li) throws SQLException {
		
		return ldao.SelectLiList(li);
	}

	@Override
	public Map<String, Object> insertNUpdateLilist(Map<String, List<LevelInfo>> map) throws SQLException {
		ldao.setConnection(DBCon.getCon());
		Map<String,Object> rMap = new HashMap<String,Object>();
		int cnt = 0;
		try {
			cnt += ldao.insertLiList(map.get("iList"));
			cnt += ldao.updateLiList(map.get("uList"));
			DBCon.commit();
			rMap.put("cnt", cnt);
			rMap.put("msg", "정상 처리");
		} catch(SQLException e) {
			rMap.put("cnt", 0);
			rMap.put("msg", "처리 에러");
			throw e;
		} finally {
			DBCon.closeCon();
		}
		return rMap;
	}

	@Override
	public Map<String, Object> deleteLilist(String[] dNums) throws SQLException {
		Map<String,Object> rMap = new HashMap<String,Object>();
		ldao.setConnection(DBCon.getCon());
		int cnt = 0;
		try {
			cnt += ldao.deleteLiList(dNums);
			DBCon.commit();
			rMap.put("cnt", cnt);
			rMap.put("msg", "정상 처리");
		} catch(SQLException e) {
			rMap.put("cnt", 0);
			rMap.put("msg", "처리 에러");
			throw e;
		} finally {
			DBCon.closeCon();
		}
		return rMap;
	}
	
//	public static void main(String[] args) {
//		LevelService ls = new LevelServiceImpl();
//		try {
//			System.out.println(ls.getLiList(null));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
