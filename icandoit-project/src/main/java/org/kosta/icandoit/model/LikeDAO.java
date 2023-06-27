package org.kosta.icandoit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class LikeDAO {
	private static LikeDAO instance = new LikeDAO();
	private DataSource dataSource;

	private LikeDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static LikeDAO getInstance() {
		return instance;
	}

	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(pstmt, con);
	}

	public void AddLike(String id, long postNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO POST_LIKE VALUES (like_seq.nextval,	?,	?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, postNo);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public ArrayList<String> findAddLikeByMemberNo(long postNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> addLikeMember = new ArrayList<>();
		try {
			con = dataSource.getConnection();
			String sql = "select m.user_id from post_like pl left join member m on pl.user_id = m.user_id where post_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, postNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				addLikeMember.add(rs.getString(1));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return addLikeMember;
	}

	public void removeLike(String id, long postNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "delete from post_like where post_no = ? and user_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, postNo);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
}
