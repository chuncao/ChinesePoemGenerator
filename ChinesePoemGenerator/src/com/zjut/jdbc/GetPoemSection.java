package com.zjut.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 获取符合条件的诗句
 * 
 * @author admin
 *
 */
public class GetPoemSection {
	/**
	 * 获取含有该文字的诗句
	 * 
	 * @param type
	 *            类型
	 * @param words
	 *            文字
	 * @return 含有改文字的诗句
	 */
	public static HashMap<Character, List<String>> getPoemSection(int type, String words) {
		HashMap<Character, List<String>> hashMap = new HashMap<>();

		Connection connection = JDBC.getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < words.length(); i++) {
			char word = words.charAt(i);

			if (hashMap.containsKey(word)) {
				continue;
			}

			ResultSet resultSet = null;

			try {
				String sql = "SELECT * FROM poem WHERE type = " + type + " and content REGEXP '" + word + "'";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();

				List<String> sections = new ArrayList<>();
				while (resultSet.next()) {
					String content = resultSet.getString("content");
					String sentence[] = content.split("。");

					for (String st : sentence) {
						String section[] = st.split("，");
						for (String s : section) {
							if (s.contains(String.valueOf(word))) {
								sections.add(s);
							}
						}
					}
				}

				hashMap.put(word, sections);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {// 关闭资源
				try {
					if (resultSet != null)
						resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		try {
			if (statement != null)
				statement.close();

			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hashMap;
	}

}
