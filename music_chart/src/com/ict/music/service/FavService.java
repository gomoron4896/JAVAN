package com.ict.music.service;

import java.util.List;

import com.ict.music.vo.FavInfo;

public interface FavService {
	public List<FavInfo> getFiList(FavInfo fi);
	public FavInfo getFi(Long mcNum);
	public Map<String,Object> init
	
}
