package com.zjut.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.zjut.dao.GetFilterByOrderPoemSection;
import com.zjut.jdbc.GetPoemSection;

public class PoemGenerateTest {

	public static void main(String[] args) {

		String words = "我爱编程";
		int type = 5;// 5、7
		int order = 0;// 0、1、2、3、4
		int rhyme = 0;// 0、1、2

		HashMap<Character, List<String>> hashMap = GetPoemSection.getPoemSection(type, words);
		HashMap<Integer, List<String>> newHashMap = GetFilterByOrderPoemSection.getFilterByOrderPoemSection(words, type,
				0, hashMap);
		System.out.println("end");
	}

	public static List<HashMap<Integer, String>> getFilterByRhymePoemSection(String words, int type, int order,
			HashMap<Integer, List<String>> hashMap) {
		List<List<String>> poemList =  new ArrayList<>();
		
		
		return null;
	}
}
