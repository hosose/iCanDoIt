package org.kosta.icandoit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private DataSource dataSource;

	private MemberDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static MemberDAO getInstance() {
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

	public void registerMember(MemberVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO MEMBER VALUES (?, ? , ?, ?,	?,	?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getNickName());
			pstmt.setString(6, vo.getName());
			int result = pstmt.executeUpdate();
			System.out.println("member register" + result);
		} finally {
			closeAll(pstmt, con);
		}
	}

	public MemberVO login(String id, String password) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			con = dataSource.getConnection();
			String sql = "select USER_ID, password, address,phone, NICK_NAME, name from member where USER_ID = ? and password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVO(id, password, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}

	public MemberVO findMemberById(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			con = dataSource.getConnection();
			String sql = "select user_id from member where user_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVO(id, null, null, null, null, null);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}

	public int checkId(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = dataSource.getConnection();
			String sql = "select count(*) from member where user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next())
				result = rs.getInt(1);
		} finally {
			closeAll(rs, pstmt, con);
		}
		return result;
	}

	public int checkNickName(String nickName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = dataSource.getConnection();
			String sql = "select count(*) from member where NICK_NAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nickName);
			rs = pstmt.executeQuery();
			if (rs.next())
				result = rs.getInt(1);
		} finally {
			closeAll(rs, pstmt, con);
		}
		return result;

	}

	public void updateMember(MemberVO memberVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder(
					"UPDATE member SET password = ?, address = ?, phone = ?, nick_name = ? ");
			sql.append("WHERE user_id = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, memberVO.getPassword());
			pstmt.setString(2, memberVO.getAddress());
			pstmt.setString(3, memberVO.getPhone());
			pstmt.setString(4, memberVO.getNickName());
			pstmt.setString(5, memberVO.getId());
			pstmt.executeUpdate();
			System.out.println("member update");
		} finally {
			closeAll(pstmt, con);
		}
	}
}
