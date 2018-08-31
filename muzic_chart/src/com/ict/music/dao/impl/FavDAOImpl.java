package com.ict.music.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.music.dao.FavDAO;
import com.ict.music.vo.FavInfo;

public class FavDAOImpl extends CommonDAOImpl implements FavDAO{
	

	@Override
	public List<FavInfo> selectFiList(FavInfo fi) throws SQLException {
		setCon();
		fiList = new ArrayList<FavInfo>();
		sql = "select * from music_chart";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				fi = new FavInfo();
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
			throw e;
		} finally {
			closeSQL();
		}
		return fiList;
	}

	@Override
	public FavInfo selectFi(Long mcNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertFavInfo(FavInfo fi) throws SQLException {
		setCon();
		int cnt = 0;
		sql = "insert into music_chart";
		sql += " (mcNum, mcName, mcSinger, mcVendor, mcLike, mcDisLike, mcCreDat, mcDesc)";
		sql += " values(seq_mcNum.nextval,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, fi.getMcName());
			ps.setString(2, fi.getMcSinger());
			ps.setString(3, fi.getMcVendor());
			ps.setLong(4, fi.getMcLike());
			ps.setLong(5, fi.getMcDisLike());
			ps.setString(6, fi.getMcCreDat());
			ps.setString(7, fi.getMcDesc());
			cnt = ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {
			con.rollback();
			closeSQL();
		}
		return cnt;
	}

	@Override
	public int updateFavInfo(FavInfo fi) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFavInfo(Long[] mcNums) throws SQLException {
		setCon();
		int cnt = 0;
		sql = "delete from music_chart where mcNum=?";
		try {
			for(Long mcNum : mcNums) {
				ps = con.prepareStatement(sql);
				ps.setLong(1, mcNum);
				cnt += ps.executeUpdate();
			}
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {
			con.rollback();
			closeSQL();
		}
		return cnt;
	}

}
