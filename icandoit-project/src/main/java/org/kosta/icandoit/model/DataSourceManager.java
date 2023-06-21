package org.kosta.icandoit.model;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

/**
 * Database Connection pool : DBCP <br>
 * 객체를 생성해 Connection을 빌려주고 반납하는<br>
 * 시스템을 운영하기 위한 클래스<br>
 * 다양한 DBCP 구현체가 존재하므로 javax.spl.DataSource 타입으로 관리한다.<br>
 * ( spring 에서도 같은 타입으로 관리 )
 * 
 * 
 * @author USER
 *
 */
public class DataSourceManager {
	private static DataSourceManager instance = new DataSourceManager();
	private DataSource dataSource;

	private DataSourceManager() {
		// apache tomcat 에서 제공하는 dbcp를 사용한다.
		BasicDataSource dbcp = new BasicDataSource();
		dbcp.setDriverClassName(DbConfig.DRIVER);
		dbcp.setUrl(DbConfig.DB_URL);
		dbcp.setUsername(DbConfig.USER_NAME);
		dbcp.setPassword(DbConfig.USER_PASS);
		dbcp.setInitialSize(10);
		dbcp.setMaxTotal(30);
		this.dataSource = dbcp;
	}

	public static DataSourceManager getInstance() {
		return instance;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
}
