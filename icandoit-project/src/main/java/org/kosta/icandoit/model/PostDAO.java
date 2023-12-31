package org.kosta.icandoit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.kosta.icandoit.test.PaginationDemo;

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
					"SELECT  p.post_no, p.title	, p.post_content	, p.img	,  p.gathering_type, TO_CHAR(gathering_period,'YYYY-MM-DD') gathering_period,  p.max_count, p.user_id ,(SELECT count(*) FROM join_club WHERE post_no = ?) current_count, m.nick_name ");
			sql.append("FROM post p	  INNER JOIN member m ON p.user_id = m.user_id WHERE p.post_no=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setLong(1, no);
			pstmt.setLong(2, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				post = new PostVO(rs.getLong("post_no"), rs.getString("title"), rs.getString("post_content"),
						rs.getString("img"), rs.getString("gathering_type"), rs.getString("gathering_period"), null,
						null, rs.getInt("current_count"), rs.getInt("max_count"),
						new MemberVO(rs.getString("user_id"), null, null, null, rs.getString("nick_name"), null));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return post;
	}

	public void joinClub(String id, long postNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuilder joinClubSql = new StringBuilder("INSERT INTO join_club ");
			joinClubSql.append("VALUES (join_club_seq.nextval,	?,	? )");
			pstmt = con.prepareStatement(joinClubSql.toString());
			pstmt.setLong(1, postNo);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public int findPostCurrentCount(long postNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int currentCount = 0;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder("SELECT count(*) FROM join_club WHERE post_no = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setLong(1, postNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				currentCount = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return currentCount;
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
			while (rs.next()) {
				joinClubMember.add(rs.getString(1));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return joinClubMember;
	}

	public ArrayList<PostVO> findPostList(PaginationDemo pagination) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PostVO> list = new ArrayList<>();
		int ButtonStatus = pagination.getButtonStatus();
		StringBuilder sb = new StringBuilder();
		PostVO postVO = null;
		try {
			con = dataSource.getConnection();
			if (ButtonStatus == 1) {
				sb.append(
						"SELECT rnum, post_no, title, post_content, category_type, img, time_posted, gathering_period, gathering_type, max_count, nick_name, current_count ");
				sb.append(
						"FROM (SELECT row_number() over(ORDER BY (SELECT count(*) FROM join_club where p.post_no = join_club.post_no) DESC) as rnum, p.post_no,p.title,p.post_content,p.category_type,p.img,TO_CHAR(p.TIME_POSTED,'YYYY-MM-DD') ");
				sb.append("time_posted,TO_CHAR(p.gathering_period,'YYYY-MM-DD') ");
				sb.append("gathering_period,p.gathering_type,p.max_count,m.nick_name, ");
				sb.append("(SELECT count(*) FROM join_club where p.post_no = join_club.post_no) as current_count ");
				sb.append("FROM post p ,member m ");
				sb.append("where p.user_id = m.user_id and gathering_type = '모집중') ");
				sb.append("WHERE rnum BETWEEN ? AND ?");
			} else if (ButtonStatus == 2) {
				sb.append(
						"SELECT rnum, post_no, title, post_content, category_type, img, time_posted, gathering_period, gathering_type, max_count, nick_name, current_count ");
				sb.append(
						"FROM (SELECT row_number() over(ORDER BY (SELECT count(*) FROM join_club where p.post_no = join_club.post_no) DESC) as rnum, p.post_no,p.title,p.post_content,p.category_type,p.img,TO_CHAR(p.TIME_POSTED,'YYYY-MM-DD') ");
				sb.append("time_posted,TO_CHAR(p.gathering_period,'YYYY-MM-DD') ");
				sb.append("gathering_period,p.gathering_type,p.max_count,m.nick_name, ");
				sb.append("(SELECT count(*) FROM join_club where p.post_no = join_club.post_no) as current_count ");
				sb.append("FROM post p ,member m ");
				sb.append("where p.user_id = m.user_id and gathering_type = '모집마감') ");
				sb.append("WHERE rnum BETWEEN ? AND ?");
			} else {
				sb.append(
						"SELECT rnum, post_no, title, post_content, category_type, img, time_posted, gathering_period, gathering_type, max_count, nick_name, current_count ");
				sb.append(
						"FROM (SELECT row_number() over(ORDER BY p.post_no DESC) as rnum, p.post_no,p.title,p.post_content,p.category_type,p.img,TO_CHAR(p.TIME_POSTED,'YYYY-MM-DD') ");
				sb.append("time_posted,TO_CHAR(p.gathering_period,'YYYY-MM-DD') ");
				sb.append("gathering_period,p.gathering_type,p.max_count,m.nick_name, ");
				sb.append("(SELECT count(*) FROM join_club where p.post_no = join_club.post_no) as current_count ");
				sb.append("FROM post p ,member m ");
				sb.append("where p.user_id = m.user_id) ");
				sb.append("WHERE rnum BETWEEN ? AND ?");
			}
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setLong(1, pagination.getStartRowNumber());
			pstmt.setLong(2, pagination.getEndRowNumber());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				postVO = new PostVO();
				postVO.setPostNo(rs.getLong("post_no"));
				postVO.setTitle(rs.getString("title"));
				postVO.setPostContent(rs.getString("post_content"));
				postVO.setImg(rs.getString("img"));
				postVO.setGatheringPeriod(rs.getString("gathering_period"));
				postVO.setGatheringType(rs.getString("gathering_type"));
				postVO.setCategoryType(rs.getString("category_type"));
				postVO.setTimePosted(rs.getString("time_posted"));
				postVO.setCurrentCount(rs.getInt("current_count"));
				postVO.setMaxCount(rs.getInt("max_count"));
				MemberVO memberVO = new MemberVO();
				memberVO.setNickName(rs.getString("nick_name"));
				postVO.setMemberVO(memberVO);
				list.add(postVO);
			}
			if (list.size() == 0) {
				return PostDAO.getInstance().findPostListDuple(pagination);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	public ArrayList<PostVO> findPostListDuple(PaginationDemo pagination) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PostVO> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		PostVO postVO = null;
		try {
			con = dataSource.getConnection();
			sb.append(
					"SELECT rnum, post_no, title, post_content, category_type, img, time_posted, gathering_period, gathering_type, max_count, nick_name, current_count ");
			sb.append(
					"FROM (SELECT row_number() over(ORDER BY p.post_no DESC) as rnum, p.post_no,p.title,p.post_content,p.category_type,p.img,TO_CHAR(p.TIME_POSTED,'YYYY-MM-DD') ");
			sb.append("time_posted,TO_CHAR(p.gathering_period,'YYYY-MM-DD') ");
			sb.append("gathering_period,p.gathering_type,p.max_count,m.nick_name, ");
			sb.append("(SELECT count(*) FROM join_club where p.post_no = join_club.post_no) as current_count ");
			sb.append("FROM post p ,member m ");
			sb.append("where p.user_id = m.user_id) ");
			sb.append("WHERE rnum BETWEEN ? AND ?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setLong(1, pagination.getStartRowNumber());
			pstmt.setLong(2, pagination.getEndRowNumber());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				postVO = new PostVO();
				postVO.setPostNo(rs.getLong("post_no"));
				postVO.setTitle(rs.getString("title"));
				postVO.setPostContent(rs.getString("post_content"));
				postVO.setImg(rs.getString("img"));
				postVO.setGatheringPeriod(rs.getString("gathering_period"));
				postVO.setGatheringType(rs.getString("gathering_type"));
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

	public void posting(PostVO post) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		long postNosql = 0;

		try {
			con = dataSource.getConnection();
			// 수동 커밋모드로 설정 ( jdbc 기본은 auto commit )
			con.setAutoCommit(false);
			sql.append("INSERT INTO POST(POST_NO,	TITLE	,	POST_CONTENT	,	IMG	,");
			sql.append("CATEGORY_TYPE,	TIME_POSTED	,	GATHERING_TYPE 	,");
			sql.append("GATHERING_PERIOD,	MAX_COUNT ,	USER_ID )");
			sql.append("VALUES (post_seq.nextval,	?,	?,	?	,	?	,");
			sql.append("sysdate,	? 	,	?	, 	? 	,	? )");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getPostContent());
			pstmt.setString(3, post.getImg());
			pstmt.setString(4, post.getCategoryType());
//			pstmt.setString(5, post.getTimePosted());
			pstmt.setString(5, post.getGatheringType());
			pstmt.setString(6, post.getGatheringPeriod());
//			pstmt.setInt(7, post.getCurrentCount());
			pstmt.setInt(7, post.getMaxCount());
			pstmt.setString(8, post.getMemberVO().getId());
			pstmt.executeUpdate();
			pstmt.close();

			StringBuilder postNoSql = new StringBuilder(
					"SELECT post_no FROM post where user_id = ? ORDER BY post_no DESC ");
			pstmt = con.prepareStatement(postNoSql.toString());
			pstmt.setString(1, post.getMemberVO().getId());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				postNosql = rs.getLong(1);
			}

			StringBuilder joinClubSql = new StringBuilder("INSERT INTO join_club ");
			joinClubSql.append("VALUES (join_club_seq.nextval,	?,	? )");
			pstmt = con.prepareStatement(joinClubSql.toString());
			pstmt.setLong(1, postNosql);
			pstmt.setString(2, post.getMemberVO().getId());
			pstmt.executeUpdate();

			con.commit();
			System.out.println("모든 작업이 정상 수행되어 commit");
		} catch (Exception e) {
			con.rollback();
			System.out.println("작업 진행 중 문제발생하여 rollback");
			// 만약 사용하는 측으로 예외를 전파해야 한다면
			throw e;
		} finally {
			closeAll(rs, pstmt, con);
		}

	}

	public long findTotalPostCount() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		long TotalPostCount = 0;
		try {
			con = dataSource.getConnection();
			String sql = "select count(*) from post";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				TotalPostCount = rs.getLong(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}

		return TotalPostCount;
	}

	public void updataGatheringType(long postNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuilder joinClubSql = new StringBuilder("UPDATE post SET GATHERING_TYPE = '모집마감' WHERE post_no = ?");
			pstmt = con.prepareStatement(joinClubSql.toString());
			pstmt.setLong(1, postNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public void leaveClub(String id, long postNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			StringBuilder leaveClubSql = new StringBuilder("DELETE FROM join_club ");
			leaveClubSql.append("WHERE post_no = ? AND user_id = ?");
			pstmt = con.prepareStatement(leaveClubSql.toString());
			pstmt.setLong(1, postNo);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			pstmt.close();
			StringBuilder updateGatheringTypeSql = new StringBuilder("UPDATE POST SET GATHERING_TYPE = '모집중' ");
			updateGatheringTypeSql.append("WHERE post_no = ?");
			pstmt = con.prepareStatement(updateGatheringTypeSql.toString());
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

	public void deletePostByNo(long no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "DELETE FROM post WHERE post_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, no);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public ArrayList<PostVO> findMyHobbyPostList(String id, MyPagePagination pagination) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PostVO> list = new ArrayList<>();
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder(
					"SELECT  rnum, post_no,  title, category_type, img, user_id, gathering_type ");
			sql.append(
					"FROM (SELECT row_number() over(ORDER BY j.post_no DESC) as rnum, j.post_no, p.title, p.category_type, p.img, p.user_id, p.gathering_type ");
			sql.append("FROM JOIN_CLUB j ");
			sql.append("INNER JOIN post p ON p.post_no=j.post_no ");
			sql.append("INNER JOIN member m ON p.user_id=m.user_id ");
			sql.append("WHERE j.user_id = ?) ");
			sql.append("WHERE rnum BETWEEN ? AND ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setLong(2, pagination.getStartRowNumber());
			pstmt.setLong(3, pagination.getEndRowNumber());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PostVO postVO = new PostVO();
				postVO.setPostNo(rs.getLong("post_no"));
				postVO.setTitle(rs.getString("title"));
				postVO.setImg(rs.getString("img"));
				postVO.setGatheringType(rs.getString("gathering_type"));
				postVO.setCategoryType(rs.getString("category_type"));
				MemberVO memberVO = new MemberVO();
				memberVO.setId(id);
				postVO.setMemberVO(memberVO);
				list.add(postVO);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	public void updatePosting(PostVO post) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		try {
			con = dataSource.getConnection();
			sql.append("UPDATE post SET TITLE=? , POST_CONTENT=? , IMG=? , ");
			sql.append("CATEGORY_TYPE=?,TIME_POSTED=sysdate ,GATHERING_PERIOD=?, MAX_COUNT=? ");
			sql.append(" WHERE POST_NO=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getPostContent());
			pstmt.setString(3, post.getImg());
			pstmt.setString(4, post.getCategoryType());
			pstmt.setString(5, post.getGatheringPeriod());
			pstmt.setInt(6, post.getMaxCount());
			pstmt.setLong(7, post.getPostNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, con);
		}

	}

	public PostVO findHobbyPostByNo(long no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PostVO post = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(
					"select post_no,title,post_content,img,category_type,time_posted,gathering_type,GATHERING_PERIOD,MAX_COUNT from post where post_no=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				post = new PostVO(no, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), null, 0, rs.getInt(9), null);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return post;
	}

	public long findTotalMyClubCount(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		long myClubCount = 0;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder(
					"SELECT count(*) FROM join_club GROUP BY user_id HAVING user_id = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				myClubCount = rs.getLong(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return myClubCount;
	}

	public long findTotalMyLikeClubCount(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		long myClubCount = 0;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder(
					"SELECT count(*) FROM post_like GROUP BY user_id HAVING user_id = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				myClubCount = rs.getLong(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return myClubCount;
	}
}
