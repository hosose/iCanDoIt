package org.kosta.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class PostDAO {
	private static PostDAO instance = new PostDAO();
	private DataSource dataSource;

	private PostDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static PostDAO getInstance() {
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

	public PostVO findPostDetail(long no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PostVO post = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder(
					"SELECT  post_no, title	, post_content	, img	,  gathering_type, gathering_period, current_count, max_count, user_id   ");
			sql.append("FROM post ");
			sql.append("WHERE post_no =? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				post = new PostVO(rs.getLong("post_no"), rs.getString("post_content"), rs.getString("img"),
						rs.getString("gathering_type"), rs.getString("gathering_period"), rs.getInt("current_count"),
						rs.getInt("max_count"), new MemberVO(rs.getString("user_id"), null, null, null, null, null));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return post;
	}
}
