package batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AddrListDAOImpl implements AddrListDAO {

	@Override
	public int insertDAO(List<List<String>> list) throws SQLException {
		Connection con = DBCon.getCon();
		System.out.println("시작");
		String sql = "insert into addr_list values(seq_alNum.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		int rCnt = 0;
		try {
			for (int j = 0; j < list.size(); j++) {
				List<String> strList = list.get(j);
				for (int i = 0; i < strList.size(); i++) {
					ps.setString(i + 1, strList.get(i));
				}
				ps.addBatch();
				ps.clearParameters();
				if (j + 1 % 100 == 0 || j + 1 == list.size()) {
					rCnt += ps.executeBatch().length;
				}
			}
			DBCon.commit();
		} catch (SQLException e) {
			DBCon.rollback();
			e.printStackTrace();
		} finally {
			DBCon.close();
		}
		System.out.println("종료");
		return rCnt;
	}

	@Override
	public int insertDAOBatch(List<List<String>> list) throws SQLException {
		Connection con = DBCon.getCon();
		String sql = "insert into addr_list values(seq_alNum.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		int rCnt = 0;
		try {
			for (int j = 0; j < list.size(); j++) {
				List<String> strList = list.get(j);
				for (int i = 0; i < strList.size(); i++) {
					ps.setString(i + 1, strList.get(0));
				}
				ps.executeUpdate();
				ps.clearParameters();
				if (j + 1 % 100 == 0 || j + 1 == strList.size()) {
					rCnt += ps.executeBatch().length;
				}
			}
			DBCon.commit();
		} catch (SQLException e) {
			DBCon.rollback();
			e.printStackTrace();
		} finally {
			DBCon.close();
		}
		return rCnt;
	}
}
