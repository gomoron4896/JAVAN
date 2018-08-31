package com.ict.music.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.music.vo.FavInfo;

public interface FavDAO {

	public List<FavInfo> selectFiList(FavInfo fi) throws SQLException;
	public FavInfo selectFi(Long mcNum) throws SQLException;
	public int insertFavInfo(FavInfo fi) throws SQLException;
	public int updateFavInfo(FavInfo fi) throws SQLException;
	public int deleteFavInfo(Long[] mcNums) throws SQLException;
	
}
