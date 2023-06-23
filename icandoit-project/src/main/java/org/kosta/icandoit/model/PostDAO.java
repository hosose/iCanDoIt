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

	public ArrayList<PostVO> findPostList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PostVO> list = new ArrayList<>();
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(
					"SELECT p.post_no,p.title,p.post_content,p.category_type,p.img,TO_CHAR(p.TIME_POSTED,'YYYY-MM-DD') time_posted,TO_CHAR(p.gathering_period,'YYYY-MM-DD') gathering_period,gathering_type,p.max_count,m.nick_name, ");
			sb.append("(SELECT count(*) FROM join_club where p.post_no = join_club.post_no) as current_count ");
			sb.append("FROM post p ,member m ,join_club j where p.user_id = m.user_id");
			String sql = sb.toString();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PostVO postVO = new PostVO();
				postVO.setPostNo(rs.getLong("post_no"));
				postVO.setTitle(rs.getString("title"));
				postVO.setPostContent(rs.getString("post_content"));
				postVO.setImg(rs.getString("img"));
				postVO.setGatheringType(rs.getString("gathering_type"));
				postVO.setGatheringPeriod(rs.getString("gathering_period"));
				postVO.setCategoryType(rs.getString("category_type"));
				postVO.setTimePosted(rs.getString("time_posted"));
				postVO.setCurrentCount(rs.getInt("current_count"));
				postVO.setMaxCount(rs.getInt("max_count"));
				MemberVO memberVO = new MemberVO();
				memberVO.setNickName(rs.getString("nick_name"));
				postVO.setMemberVO(memberVO);
				list.add(postVO);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
}
