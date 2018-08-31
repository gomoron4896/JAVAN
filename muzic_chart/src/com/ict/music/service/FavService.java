package com.ict.music.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.music.vo.FavInfo;

public interface FavService {
	public List<FavInfo> getFiList(FavInfo fi) throws SQLException;
	public FavInfo getFi(Long mcNum) throws SQLException;
	public Map<String,Object> addFavInfo(FavInfo fi) throws SQLException;
	public Map<String,Object> modifyFavInfo(FavInfo fi) throws SQLException;
	public Map<String,Object> removeFavInfo(Long[] mcNums) throws SQLException;
	
}
