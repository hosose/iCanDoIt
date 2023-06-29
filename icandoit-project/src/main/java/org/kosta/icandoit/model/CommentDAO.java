package org.kosta.icandoit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class CommentDAO {
	private static CommentDAO instance = new CommentDAO();
	private DataSource dataSource;

	private CommentDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static CommentDAO getInstance() {
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

	public void registerComment(CommentVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO post_comment	VALUES (comment_seq.nextval, ?,	 ?,	 ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getCommentContent());
			pstmt.setLong(2, vo.getPostVo().getPostNo());
			pstmt.setString(3, vo.getMemberVO().getId());
			int result = pstmt.executeUpdate();
			System.out.println("댓글등록완" + result);
		} finally {
			closeAll(pstmt, con);
		}
	}

	public ArrayList<CommentVO> findCommentListByPostNo(long postNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommentVO> list = new ArrayList<>();
		try {
			con = dataSource.getConnection();
			String sql = "select comment_no, nick_name, pc.comment_content, m.user_id "
					+ "from member m inner join post_comment pc on m.user_id = pc.user_id inner join post p on pc.post_no=p.post_no "
					+ "where p.post_no = ? " + "order by comment_no desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, postNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CommentVO commentVO = new CommentVO();
				commentVO.setCommentNo(rs.getLong("comment_no"));
				commentVO.setCommentContent(rs.getString("comment_content"));
				MemberVO memberVO = new MemberVO();
				memberVO.setNickName(rs.getString("nick_name"));
				memberVO.setId(rs.getString("user_id"));
				commentVO.setMemberVO(memberVO);
				list.add(commentVO);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	public void deleteCommentByNo(long commentNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "DELETE FROM POST_COMMENT WHERE COMMENT_NO =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, commentNo);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
}
