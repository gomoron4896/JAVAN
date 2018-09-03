package com.ict.erp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MemberDAO;
import com.ict.erp.vo.MemberInfo;

public class MemberDAOImpl extends CommonDAOImpl implements MemberDAO {

	@Override
	public List<MemberInfo> selectMiList(MemberInfo mi) throws SQLException {
		String sql = "SELECT mi.*, di.diname, li.liname from "
				+ "MEMBER_INFO mi, DEPART_INFO di, LEVEL_INFO li "
				+ "where mi.dicode = di.dicode "
				+ "and mi.LILEVEL = li.LIlevel ";
		List<MemberInfo> miList = new ArrayList<MemberInfo>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberInfo mmi = new MemberInfo();
				mmi.setDiCode(rs.getString("diCode"));
				mmi.setLiLevel(rs.getLong("liLevel"));
				mmi.setMiAddress1(rs.getString("miAddress1"));
				mmi.setMiAddress2(rs.getString("miAddress2"));
				mmi.setMiDesc(rs.getString("miDesc"));
				mmi.setMiEmail(rs.getString("miEmail"));
				mmi.setMiId(rs.getString("miId"));
				mmi.setMiName(rs.getString("miName"));
				mmi.setMiNum(rs.getLong("miNum"));
				mmi.setMiPhone(rs.getString("miPhone"));
				mmi.setMiPwd(rs.getString("miPwd"));
				mmi.setMiZipcode(rs.getString("miZipcode"));
				mmi.setLiName(rs.getString("liName"));
				mmi.setDiName(rs.getString("diName"));
				miList.add(mmi); 
			}
			return miList;
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	public static void main(String[] args) {
		MemberDAO mdao = new MemberDAOImpl();
		mdao.setConnection(DBCon.getCon());
		try {
			if(mdao.selectMiList(null).size()==0) {
				System.out.println("성공");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insertMi(MemberInfo mi) throws SQLException {
		String sql = "insert into member_info(MINUM,\r\n" + 
				"MIID,\r\n" + 
				"MINAME,\r\n" + 
				"MIPWD,\r\n" + 
				"DICODE,\r\n" + 
				"MIEMAIL,\r\n" + 
				"MIDESC,\r\n" + 
				"MIPHONE,\r\n" + 
				"MIZIPCODE,\r\n" + 
				"MIADDRESS1,\r\n" + 
				"MIADDRESS2,\r\n" + 
				"LILEVEL)";
		sql += "values(seq_minum.nextval,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mi.getMiId());
			ps.setString(2, mi.getMiName());
			ps.setString(3, mi.getMiPwd());
			ps.setString(4, mi.getDiCode());
			ps.setString(5, mi.getMiEmail());
			ps.setString(6, mi.getMiDesc());
			ps.setString(7, mi.getMiPhone());
			ps.setString(8, mi.getMiZipcode());
			ps.setString(9, mi.getMiAddress1());
			ps.setString(10, mi.getMiAddress2());
			ps.setLong(11, mi.getLiLevel());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}
	}

	@Override
	public int updateMi(MemberInfo mi) throws SQLException{
		String sql = "update member_info"
				+ " set " + 
				"MIID=?,\r\n" + 
				"MINAME=?,\r\n" + 
				"MIPWD=?,\r\n" + 
				"DICODE=?,\r\n" + 
				"MIEMAIL=?,\r\n" + 
				"MIDESC=?,\r\n" + 
				"MIPHONE=?,\r\n" + 
				"MIZIPCODE=?,\r\n" + 
				"MIADDRESS1=?,\r\n" + 
				"MIADDRESS2=?,\r\n" + 
				"LILEVEL=? where miNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mi.getMiId());
			ps.setString(2, mi.getMiName());
			ps.setString(3, mi.getMiPwd());
			ps.setString(4, mi.getDiCode());
			ps.setString(5, mi.getMiEmail());
			ps.setString(6, mi.getMiDesc());
			ps.setString(7, mi.getMiPhone());
			ps.setString(8, mi.getMiZipcode());
			ps.setString(9, mi.getMiAddress1());
			ps.setString(10, mi.getMiAddress2());
			ps.setLong(11, mi.getLiLevel());
			ps.setLong(12, mi.getMiNum());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}
	}

	@Override
	public int deleteMi(MemberInfo mi)throws SQLException {
		String sql = "delete from member_info where miNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, mi.getMiNum());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}
	}

	@Override
	public MemberInfo selectMemberInfo(MemberInfo mi) throws SQLException {
		String sql = "SELECT * from "
				+ " MEMBER_INFO mi"
				+ " where miNum=? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, mi.getMiNum());
			rs = ps.executeQuery();
			if(rs.next()) {
				MemberInfo mmi = new MemberInfo();
				mmi.setDiCode(rs.getString("diCode"));
				mmi.setLiLevel(rs.getLong("liLevel"));
				mmi.setMiAddress1(rs.getString("miAddress1"));
				mmi.setMiAddress2(rs.getString("miAddress2"));
				mmi.setMiDesc(rs.getString("miDesc"));
				mmi.setMiEmail(rs.getString("miEmail"));
				mmi.setMiId(rs.getString("miId"));
				mmi.setMiName(rs.getString("miName"));
				mmi.setMiNum(rs.getLong("miNum"));
				mmi.setMiPhone(rs.getString("miPhone"));
				mmi.setMiPwd(rs.getString("miPwd"));
				mmi.setMiZipcode(rs.getString("miZipcode"));
				return mmi; 
			}
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
		return null;
	}



}