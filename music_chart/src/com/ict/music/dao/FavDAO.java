package com.ict.music.dao;

import java.util.List;
import java.util.Map;

import com.ict.music.vo.FavInfo;

public interface FavDAO {

	public List<FavInfo> selectFiList(FavInfo fi);
	public FavInfo selectFi(Long mcNum);
	public int insertFavInfo(FavInfo fi);
	public int updateFavInfo(FavInfo fi);
	public int deleteFavInfo(FavInfo fi);
	
}
