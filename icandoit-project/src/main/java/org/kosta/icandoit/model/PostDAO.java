package org.kosta.icandoit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
					"SELECT  p.post_no, p.title	, p.post_content	, p.img	,  p.gathering_type, TO_CHAR(gathering_period,'YYYY-MM-DD') gathering_period,  p.max_count, p.user_id ,(SELECT count(*) FROM join_club WHERE post_no = ?) current_count ");
			sql.append("FROM post p	 WHERE p.post_no=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setLong(1, no);
			pstmt.setLong(2, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				post = new PostVO(rs.getLong("post_no"), rs.getString("title"), rs.getString("post_content"),
						rs.getString("img"), rs.getString("gathering_type"), rs.getString("gathering_period"), null,
						null, rs.getInt("current_count"), rs.getInt("max_count"),
						new MemberVO(rs.getString("user_id"), null, null, null, null, null));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return post;
	}

	public void joinClub(String memberId, long postNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuilder joinClubSql = new StringBuilder("INSERT INTO join_club ");
			joinClubSql.append("VALUES (join_club_seq.nextval,	?,	? )");
			pstmt = con.prepareStatement(joinClubSql.toString());
			pstmt.setLong(1, postNo);
			pstmt.setString(2, memberId);
			pstmt.executeUpdate();
			pstmt.close();
			StringBuilder postSql = new StringBuilder("UPDATE post SET current_count = current_count + 1 ");
			postSql.append("WHERE post_no = ?");
			pstmt = con.prepareStatement(postSql.toString());
			pstmt.setLong(1, postNo);
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			closeAll(pstmt, con);
		}
	}

	public int findPostCurrentCount(long postNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int currenCount = 0;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder("SELECT count(*) FROM join_club WHERE post_no = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setLong(1, postNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				currenCount = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return currenCount;
	}

	public int findPostmaxCount(long postNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int maxCount = 0;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder("SELECT max_count FROM post WHERE post_no = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setLong(1, postNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				maxCount = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return maxCount;
	}

	public ArrayList<String> findJoinClubMember(long postNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> joinClubMember = new ArrayList<>();
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder(
					"SELECT m.nick_name FROM join_club j LEFT JOIN member m ON j.user_id = m.user_id WHERE post_no=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setLong(1, postNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				joinClubMember.add(rs.getString(1));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return joinClubMember;
	}
}
