package com.zjut.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.json.JSONObject;

import com.zjut.jdbc.GetPoemSection;

/**
 * 获取符合条件的诗
 * 
 * @author admin
 *
 */
public class GetPoem {
	/**
	 * 获取符合条件的组合诗句
	 * 
	 * @param str
	 *            文字
	 * @return 符合条件的组合诗句
	 */
	public static String GetPoem(String str) {
		JSONObject jsonObject = new JSONObject(str);
		String words = jsonObject.getString("words");
		int type = Integer.parseInt(jsonObject.getString("type"));
		int order = Integer.parseInt(jsonObject.getString("order"));

		HashMap<Character, List<String>> hashMap = GetPoemSection.getPoemSection(type, words);
		HashMap<Integer, List<String>> newHashMap = GetFilterByOrderPoemSection.getFilterByOrderPoemSection(words, type,
				order, hashMap);

		String string = "";
		HashSet<String> hashSet = new HashSet<>();
		for (Integer key : newHashMap.keySet()) {

			List<String> sectionList = newHashMap.get(key);

			int i = 0;
			if (!sectionList.isEmpty()) {
				for (i = 0; i < sectionList.size(); i++) {
					String section = sectionList.get(i);
					if (!hashSet.contains(section)) {
						hashSet.add(section);
						string += section;
						break;
					}
				}
			}

			if (key % 2 == 0) {
				string += "，";
			} else {
				string += "。";
			}

			string += "（" + (sectionList.size() - i) + "）" + "\n";
		}

		return string;
	}
}
