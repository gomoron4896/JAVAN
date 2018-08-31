package com.ict.music.service.impl;

import java.util.List;
import java.util.Map;

import com.ict.music.dao.FavDAO;
import com.ict.music.dao.impl.FavDAOImpl;
import com.ict.music.service.FavService;
import com.ict.music.vo.FavInfo;

public class FavServiceImpl implements FavService {
	
	private FavDAO fdao; 

	@Override
	public List<FavInfo> getFiList(FavInfo fi) {
		fdao = new FavDAOImpl();
		return fdao.selectFiList(fi);
	}

	@Override
	public FavInfo getFi(Long mcNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> addFavInfo(FavInfo fi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> modifyFavInfo(FavInfo fi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> removeFavInfo(FavInfo fi) {
		// TODO Auto-generated method stub
		return null;
	}

}
