package com.zjut.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zjut.jdbc.JDBC;

public class JDBCTest {

	public static void main(String[] args) {
		System.out.println("start");
		Connection connection = JDBC.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from name");

			while (resultSet.next()) {
				System.out.println(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {// 关闭资源
			try {
				if (resultSet != null)
					resultSet.close();

				if (statement != null)
					statement.close();

				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
