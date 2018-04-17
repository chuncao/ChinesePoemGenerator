package com.zjut.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjut.dao.GetPoem;

/**
 * 生成组合诗
 * 
 * @author admin
 *
 */
public class PoemGenerate extends HttpServlet {
	static String words;
	static int type;
	static int order;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		String str = req.getParameter("data");// 得到ajax传递过来的paramater

		String poem = GetPoem.GetPoem(str);
		String json = "{\"poem\":\"" + poem.replace("\n", "\\n") + "\"}";

		PrintWriter out = resp.getWriter();

		out.print(json);// 返给ajax请求
	}
}
