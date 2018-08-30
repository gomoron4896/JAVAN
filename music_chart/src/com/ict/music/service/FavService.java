package com.ict.music.service;

import java.util.List;
import java.util.Map;

import com.ict.music.vo.FavInfo;

public interface FavService {
	public List<FavInfo> getFiList(FavInfo fi);
	public FavInfo getFi(Long mcNum);
	public Map<String,Object> addFavInfo(FavInfo fi);
	public Map<String,Object> modifyFavInfo(FavInfo fi);
	public Map<String,Object> removeFavInfo(FavInfo fi);
	
}
