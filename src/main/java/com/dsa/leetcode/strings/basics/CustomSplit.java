package com.dsa.leetcode.strings.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomSplit {

	public static void main(String[] args) {
		
		String str = Arrays.toString(customSplit("Today is a good day, be happy", " "));
		System.out.println(str);

	}

	public static String[] customSplit(String str, String token) {
		if (str == null || token== null || token.isEmpty()) {
			throw new IllegalArgumentException("Invalid arguments");
		}

		List<String> result = new ArrayList<>();
		int start = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == token.charAt(0)) {
				
				// Check if the entire token matches
				boolean found = true;
				for (int j = 1; j < token.length() && i + j < str.length(); j++) {
					if (str.charAt(i + j) != token.charAt(j)) {
						found = false;
						break;
					}
				}
				if (found) {
					result.add(str.substring(start, i));
					start = i + token.length();
				}
			}
		}
		result.add(str.substring(start)); // Add the remaining string
//		System.out.println(result);
		return result.toArray(new String[0]);
	}

}
