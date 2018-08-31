package com.ict.music.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.music.dao.FavDAO;
import com.ict.music.vo.FavInfo;

public class FavDAOImpl extends CommonDAOImpl implements FavDAO{
	

	@Override
	public List<FavInfo> selectFiList(FavInfo fi) {
		setCon();
		fiList = new ArrayList<FavInfo>();
		sql = "select * from music_chart";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				fi.setMcNum(rs.getLong("mcNum"));
				fi.setMcName(rs.getString("mcName"));
				fi.setMcSinger(rs.getString("mcSinger"));
				fi.setMcVendor(rs.getString("mcVendor"));
				fi.setMcLike(rs.getLong("mcLike"));
				fi.setMcDisLike(rs.getLong("mcDisLike"));
				fi.setMcCreDat(rs.getString("mcCreDat"));
				fi.setMcDesc(rs.getString("mcDesc"));
				fiList.add(fi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fiList;
	}

	@Override
	public FavInfo selectFi(Long mcNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertFavInfo(FavInfo fi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFavInfo(FavInfo fi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFavInfo(FavInfo fi) {
		// TODO Auto-generated method stub
		return 0;
	}

}
