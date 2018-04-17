package com.zjut.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 获取文字所藏位置后的诗句
 * 
 * @author admin
 *
 */
public class GetFilterByOrderPoemSection {
	/**
	 * 获取文字所藏位置后的诗句
	 * 
	 * @param words
	 *            文字
	 * @param type
	 *            类型
	 * @param order
	 *            所藏类型
	 * @param hashMap
	 *            含有文字的诗句
	 * @return
	 */
	public static HashMap<Integer, List<String>> getFilterByOrderPoemSection(String words, int type, int order,
			HashMap<Character, List<String>> hashMap) {
		HashMap<Integer, List<String>> newHashMap = new HashMap<>();

		if (order == 3 || order == 4) {// 递增、递减
			int loopNum = (type - 1) * 2;

			for (int i = 0; i < words.length(); i++) {
				int newOrder = getNewOrder(type, order, loopNum, i);

				List<String> newSections = filterPoemSectionByOrder(words, i, newOrder, hashMap);

				newHashMap.put(i, newSections);
			}
		} else {// 藏头、藏尾、藏中
			int newOrder = getOrder(type, order);

			for (int i = 0; i < words.length(); i++) {
				List<String> newSections = filterPoemSectionByOrder(words, i, newOrder, hashMap);

				newHashMap.put(i, newSections);
			}
		}

		return newHashMap;
	}

	/**
	 * 根据所藏位置筛选诗句
	 * 
	 * @param words
	 *            文字
	 * @param index
	 *            文字位置
	 * @param newOrder
	 *            文字新位置
	 * @param hashMap
	 *            含有文字的诗句
	 * @return 筛选含所藏位置文字的诗句
	 */
	private static List<String> filterPoemSectionByOrder(String words, int index, int newOrder,
			HashMap<Character, List<String>> hashMap) {
		char word = words.charAt(index);
		List<String> newSections = new ArrayList<>();

		for (String section : hashMap.get(word)) {
			if (section.charAt(newOrder) == word) {
				newSections.add(section);
			}
		}

		return newSections;
	}

	/**
	 * 获取递增、递减文字的位置
	 * 
	 * @param type
	 *            类型
	 * @param order
	 *            所藏类型
	 * @param loopNum
	 *            循环周期
	 * @param line
	 *            行号
	 * @return 递增、递减文字的位置
	 */
	private static int getNewOrder(int type, int order, int loopNum, int line) {
		int newOrder = 0;

		int remainder = line % loopNum;

		if (order == 3) {// 递增
			if (remainder <= type - 1) {
				newOrder = remainder;
			} else {
				newOrder = loopNum - remainder;
			}
		} else {// 递减
			if (remainder <= type - 1) {
				newOrder = type - 1 - remainder;
			} else {
				newOrder = line % (type - 1);
			}
		}

		return newOrder;
	}

	/**
	 * 获取藏头、藏尾、藏中文字的位置
	 * 
	 * @param type
	 *            类型
	 * @param order
	 *            所藏类型
	 * @return 藏头、藏尾、藏中文字的位置
	 */
	private static int getOrder(int type, int order) {
		int newOrder = 0;

		switch (order) {
		case 0:// 藏头
			break;
		case 1:// 藏尾
			newOrder = type - 1;
			break;
		case 2:// 藏中
			newOrder = type / 2;
			break;
		}

		return newOrder;
	}
}
