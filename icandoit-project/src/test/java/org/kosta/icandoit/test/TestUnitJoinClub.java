package org.kosta.icandoit.test;

import java.sql.SQLException;

import org.kosta.icandoit.model.PostDAO;

public class TestUnitJoinClub {

	public static void main(String[] args) {
		try {
			PostDAO.getInstance().joinClub("java", 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
