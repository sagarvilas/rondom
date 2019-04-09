package org.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonWords {

	public static String mostCommonWord(String paragraph, String[] banned) {

		List<String> words = Arrays.asList(banned);

		paragraph = paragraph.replaceAll("[^A-Za-z0-9]", " ").toLowerCase().replaceAll("\\s{2,}", " ").trim();

		int max = 0;
		String common = "";
		Map<String, Integer> frequencyMap = new HashMap<>();
		for (String s : paragraph.split(" ")) {
			if (!words.contains(s)) {
				frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
				if (frequencyMap.get(s) > max) {
					max = frequencyMap.get(s);
					common = s;
				}
			}
		}
		return common;
	}

	public static void main(String[] args) {
		String[] s = { "abc", "abcd", "jeff" };
		mostCommonWord("abc abc? abcd the jeff!", s);
	}
}
