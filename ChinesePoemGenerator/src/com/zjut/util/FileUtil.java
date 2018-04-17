package com.zjut.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author admin
 */
public class FileUtil {
	/**
	 * 向文件中写入文本
	 *
	 * @param file
	 *            需要操作的文件
	 * @param str
	 *            写入的文本
	 * @throws IOException
	 *             I/O 异常
	 */
	public static void write(File file, String str) throws IOException {
		writeToFile(file, str, null, false, false);
	}

	/**
	 * 向文件中写入文本
	 *
	 * @param file
	 *            需要操作的文件
	 * @param str
	 *            写入的文本
	 * @param append
	 *            是否追加至末尾
	 * @throws IOException
	 *             I/O 异常
	 */
	public static void write(File file, String str, boolean append) throws IOException {
		writeToFile(file, str, null, append, false);
	}

	/**
	 * 向文件中写入文本
	 *
	 * @param file
	 *            需要操作的文件
	 * @param str
	 *            写入的文本
	 * @param append
	 *            是否追加至末尾
	 * @param newLine
	 *            是否换行
	 * @throws IOException
	 *             I/O 异常
	 */
	public static void write(File file, String str, boolean append, boolean newLine) throws IOException {
		writeToFile(file, str, null, append, newLine);
	}

	/**
	 * 向文件中写入文本
	 *
	 * @param file
	 *            需要操作的文件
	 * @param str
	 *            写入的文本
	 * @param charsetName
	 *            文件编码名
	 * @throws IOException
	 *             I/O 异常
	 */
	public static void write(File file, String str, String charsetName) throws IOException {
		writeToFile(file, str, charsetName, false, false);
	}

	/**
	 * 向文件中写入文本
	 *
	 * @param file
	 *            需要操作的文件
	 * @param str
	 *            写入的文本
	 * @param charsetName
	 *            文件编码名
	 * @param append
	 *            是否追加至末尾
	 * @throws IOException
	 *             I/O 异常
	 */
	public static void write(File file, String str, String charsetName, boolean append) throws IOException {
		writeToFile(file, str, charsetName, append, false);
	}

	/**
	 * 向文件中写入文本
	 *
	 * @param file
	 *            需要操作的文件
	 * @param str
	 *            写入的文本
	 * @param charsetName
	 *            文件编码名
	 * @param append
	 *            是否追加至末尾
	 * @param newLine
	 *            是否换行
	 * @throws IOException
	 *             I/O 异常
	 */
	public static void write(File file, String str, String charsetName, boolean append, boolean newLine)
			throws IOException {
		writeToFile(file, str, charsetName, append, newLine);
	}

	/**
	 * 向文件中写入文本
	 *
	 * @param pathname
	 *            需要操作的文件路径
	 * @param str
	 *            写入的文本
	 * @throws IOException
	 *             I/O 异常
	 */
	public static void write(String pathname, String str) throws IOException {
		File file = new File(pathname);

		writeToFile(file, str, null, false, false);
	}

	/**
	 * 向文件中写入文本
	 *
	 * @param pathname
	 *            需要操作的文件路径
	 * @param str
	 *            写入的文本
	 * @param append
	 *            是否追加至末尾
	 * @throws IOException
	 *             I/O 异常
	 */
	public static void write(String pathname, String str, boolean append) throws IOException {
		File file = new File(pathname);

		writeToFile(file, str, null, append, false);
	}

	/**
	 * 向文件中写入文本
	 *
	 * @param pathname
	 *            需要操作的文件路径
	 * @param str
	 *            写入的文本
	 * @param append
	 *            是否追加至末尾
	 * @param newLine
	 *            是否换行
	 * @throws IOException
	 *             I/O 异常
	 */
	public static void write(String pathname, String str, boolean append, boolean newLine) throws IOException {
		File file = new File(pathname);

		writeToFile(file, str, null, append, newLine);
	}

	/**
	 * 向文件中写入文本
	 *
	 * @param pathname
	 *            需要操作的文件路径
	 * @param str
	 *            写入的文本
	 * @param charsetName
	 *            文件编码名
	 * @throws IOException
	 *             I/O 异常
	 */
	public static void write(String pathname, String str, String charsetName) throws IOException {
		File file = new File(pathname);

		writeToFile(file, str, charsetName, false, false);
	}

	/**
	 * 向文件中写入文本
	 *
	 * @param pathname
	 *            需要操作的文件路径
	 * @param str
	 *            写入的文本
	 * @param charsetName
	 *            文件编码名
	 * @param append
	 *            是否追加至末尾
	 * @throws IOException
	 *             I/O 异常
	 */
	public static void write(String pathname, String str, String charsetName, boolean append) throws IOException {
		File file = new File(pathname);

		writeToFile(file, str, charsetName, append, false);
	}

	/**
	 * 向文件中写入文本
	 *
	 * @param pathname
	 *            需要操作的文件路径
	 * @param str
	 *            写入的文本
	 * @param charsetName
	 *            文件编码名
	 * @param append
	 *            是否追加至末尾
	 * @param newLine
	 *            是否换行
	 * @throws IOException
	 *             I/O 异常
	 */
	public static void write(String pathname, String str, String charsetName, boolean append, boolean newLine)
			throws IOException {
		File file = new File(pathname);

		writeToFile(file, str, charsetName, append, newLine);
	}

	/**
	 * 向文件中写入文本
	 *
	 * @param file
	 *            需要操作的文件
	 * @param str
	 *            写入的文本
	 * @param charsetName
	 *            文件编码名
	 * @param append
	 *            是否追加至末尾
	 * @param newLine
	 *            是否换行
	 * @throws IOException
	 *             I/O 异常
	 */
	private static void writeToFile(File file, String str, String charsetName, boolean append, boolean newLine)
			throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(file, append);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

		OutputStreamWriter outputStreamWriter;
		if (charsetName == null) {
			outputStreamWriter = new OutputStreamWriter(bufferedOutputStream);
		} else {
			outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, charsetName);
		}

		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

		if (newLine)
			bufferedWriter.newLine();

		bufferedWriter.write(str);
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	/**
	 * 从文件中读入文本
	 *
	 * @param file
	 *            需要操作的文件
	 * @return 文件文本
	 * @throws IOException
	 *             I/O 异常
	 */
	public static String read(File file) throws IOException {
		return read(file, null);
	}

	/**
	 * 从文件中读入文本
	 *
	 * @param pathname
	 *            需要操作的文件路径
	 * @return 文件文本
	 * @throws IOException
	 *             I/O 异常
	 */
	public static String read(String pathname) throws IOException {
		return read(new File(pathname), null);
	}

	/**
	 * 从文件中读入文本
	 *
	 * @param file
	 *            需要操作的文件路径
	 * @param charsetName
	 *            文件编码名
	 * @return 文件文本
	 * @throws IOException
	 *             I/O 异常
	 */
	public static String read(String pathname, String charsetName) throws IOException {
		return read(new File(pathname), charsetName);
	}

	/**
	 * 从文件中读入文本
	 *
	 * @param file
	 *            需要操作的文件
	 * @param charsetName
	 *            文件编码名
	 * @return 文件文本
	 * @throws IOException
	 *             I/O 异常
	 */
	public static String read(File file, String charsetName) throws IOException {
		String finalStr = "";

		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

		InputStreamReader inputStreamReader;
		if (charsetName == null) {
			inputStreamReader = new InputStreamReader(bufferedInputStream);
		} else {
			inputStreamReader = new InputStreamReader(bufferedInputStream, charsetName);
		}

		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String tempStr = null;
		while ((tempStr = bufferedReader.readLine()) != null) {
			finalStr += tempStr;
			finalStr += "\n";
		}

		bufferedReader.close();
		bufferedInputStream.close();
		fileInputStream.close();

		return finalStr;
	}
}
