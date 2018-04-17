package com.zjut.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zjut.bean.Poem;
import com.zjut.jdbc.JDBC;

/**
 * 将源诗句中五言、七言添加到数据库中
 * 
 * @author admin
 *
 */
public class AddPoem {

	public static void main(String[] args) throws IOException {

		final String pathname = "./sourceFile/poetry.txt";
		File file = new File(pathname);

		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

		InputStreamReader inputStreamReader;
		inputStreamReader = new InputStreamReader(bufferedInputStream);

		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		List<Poem> poemList = new ArrayList<>();
		String tempStr = null;
		int totalNum = 0;
		int filterNum = 0;
		while ((tempStr = bufferedReader.readLine()) != null) {
			++totalNum;
			List<String> allSection = new ArrayList<>();

			String str[] = tempStr.split(":");
			if (str.length < 2) {
				continue;
			}
			String sentence[] = str[1].split("。");

			for (String st : sentence) {
				String section[] = st.split("，");
				for (String s : section) {
					allSection.add(s);
				}
			}

			int sectionLength = allSection.get(0).length();
			if (sectionLength != 5 && sectionLength != 7) {// 五言、七言
				continue;
			}

			boolean flag = true;
			for (int i = 1; i < allSection.size(); i++) {
				int nextSectionLength = allSection.get(i).length();
				if (nextSectionLength != sectionLength) {
					flag = false;
					break;
				}
			}

			if (!flag) {
				continue;
			}

			++filterNum;

			Poem poem = new Poem();
			poem.setType(sectionLength);
			poem.setTitle(str[0]);
			poem.setContent(str[1]);
			poemList.add(poem);
		}

		bufferedReader.close();
		bufferedInputStream.close();
		fileInputStream.close();

		System.out.println("totalNum = " + totalNum);
		System.out.println("filterNum = " + filterNum);

		Connection connection = JDBC.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;

		int i = 0;
		try {
			statement = connection.createStatement();

			for (i = 0; i < poemList.size(); i++) {
				Poem author = poemList.get(i);
				String sql = "insert into poem(type,title,poem) values('" + author.getType() + "','" + author.getTitle()
						+ "','" + author.getContent() + "')";
				PreparedStatement s = connection.prepareStatement(sql);
				s.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {// 关闭资源
			try {
				System.out.println("insertNum = " + i);
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

		System.out.println("end");
	}
}