package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MemberDAO;
import com.ict.erp.dao.impl.MemberDAOImpl;
import com.ict.erp.service.MemberService;
import com.ict.erp.vo.MemberInfo;

public class MemberServiceImpl implements MemberService {
	private MemberDAO mdao = new MemberDAOImpl();
	@Override
	public List<MemberInfo> selectMiList(MemberInfo mi) throws SQLException {
		// TODO Auto-generated method stub
		mdao.setConnection(DBCon.getCon());
		try {
			return mdao.selectMiList(mi);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public MemberInfo selectMi(MemberInfo mi) throws SQLException{
		mdao.setConnection(DBCon.getCon());
		try {
			return mdao.selectMemberInfo(mi);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> insertMi(MemberInfo mi) throws SQLException {
		// TODO Auto-generated method stub
		mdao.setConnection(DBCon.getCon());
		try {
			int cnt = mdao.insertMi(mi);
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("cnt", cnt);
			rMap.put("msg", "사원 등록 실패");
			if(cnt==1) {
				rMap.put("msg", "사원 등록 성공");
			}
			return rMap;
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> updateMi(MemberInfo mi) throws SQLException{
		// TODO Auto-generated method stub
		mdao.setConnection(DBCon.getCon());
		try {
			int cnt = mdao.updateMi(mi);
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("cnt", cnt);
			rMap.put("msg", "사원 수정 실패");
			if(cnt==1) {
				rMap.put("msg", "사원 수정 성공");
			}
			return rMap;
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> deleteMi(MemberInfo mi) throws SQLException{
		// TODO Auto-generated method stub
		mdao.setConnection(DBCon.getCon());
		try {
			int cnt = mdao.deleteMi(mi);
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("cnt", cnt);
			rMap.put("msg", "사원 삭제 실패");
			if(cnt==1) {
				rMap.put("msg", "사원 삭제 성공");
			}
			return rMap;
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

}