package com.ict.music.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.music.dao.FavDAO;
import com.ict.music.dao.impl.FavDAOImpl;
import com.ict.music.service.FavService;
import com.ict.music.vo.FavInfo;

public class FavServiceImpl implements FavService {
	
	private FavDAO fdao; 

	@Override
	public List<FavInfo> getFiList(FavInfo fi) throws SQLException {
		fdao = new FavDAOImpl();
		return fdao.selectFiList(fi);
	}

	@Override
	public FavInfo getFi(Long mcNum) {
		return null;
	}

	@Override
	public Map<String, Object> addFavInfo(FavInfo fi) throws SQLException {
		fdao = new FavDAOImpl();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("cnt", fdao.insertFavInfo(fi));
		String msg = null;
		if((int)resultMap.get("cnt")==1) {
			msg = "입력 성공";
		} else {
			msg = "입력 실패";
		}
		resultMap.put("msg",msg);
		return resultMap;
	}

	@Override
	public Map<String, Object> modifyFavInfo(FavInfo fi) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> removeFavInfo(Long[] mcNums) throws SQLException {
		fdao = new FavDAOImpl();
		Map<String, Object> deleteResult = new HashMap<String, Object>();
		deleteResult.put("cnt", fdao.deleteFavInfo(mcNums));
		String msg = null;
		if((int)deleteResult.get("cnt")==1) {
			msg = "삭제 성공";
		} else {
			msg = "삭제 실패";
		}
		deleteResult.put("msg",msg);
		return deleteResult;
	}

}
