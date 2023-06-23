package org.kosta.icandoit.test;

import java.sql.SQLException;

import org.kosta.icandoit.model.PostDAO;

public class TestUnitFindPostByNo {
	public static void main(String[] args) {
		try {
			System.out.println(PostDAO.getInstance().findPostDetail(1));
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
