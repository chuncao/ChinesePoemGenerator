package com.zjut.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库连接配置
 * 
 * @author admin
 *
 */
public class JDBC {
	static final String url = "jdbc:mysql://localhost:3306/poem?useUnicode=true&characterEncoding=utf8";
	static final String name = "com.mysql.jdbc.Driver";
	static final String user = "root";
	static final String password = "zjuta203";

	public static Connection getConnection() {
		Connection connection = null;

		// 加载驱动程序
		try {
			Class.forName(name);
			// 1.getConnection()方法，连接MySQL数据库！！
			connection = DriverManager.getConnection(url, user, password);
			if (!connection.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}
}