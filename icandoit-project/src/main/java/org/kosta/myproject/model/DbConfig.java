package org.kosta.myproject.model;

public interface DbConfig {
	String DRIVER = "oracle.jdbc.OracleDriver";
	String DB_URL = "jdbc:oracle:thin:@13.125.234.240:1521:xe";
	String USER_NAME = "scott";
	String USER_PASS = "tiger";
}
