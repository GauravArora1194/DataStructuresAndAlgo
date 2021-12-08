package com.interview.strings;

import java.util.HashMap;
import java.util.Map;

public class TinyUrl {

	private static Map<String, String> index = new HashMap<>();
	private static Map<String, String> revIndex = new HashMap<>();
	private static String BASE_HOST = "http://tinyurl.com/";

	public static void main(String[] args) {

		String url = "https://leetcode.com/problems/design-tinyurl";
		String encodedUrl = encode(url);
		System.out.println(encodedUrl);
		String decodedUrl = decode(encodedUrl);
		System.out.println(decodedUrl);

	}

	// Encodes a URL to a shortened URL.
	public static String encode(String longUrl) {
		if (revIndex.containsKey(longUrl))
			return BASE_HOST + revIndex.get(longUrl);
		String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String key = null;
		do {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				int r = (int) (Math.random() * charSet.length());
				sb.append(charSet.charAt(r));
			}
			key = sb.toString();
		} while (index.containsKey(key));
		index.put(key, longUrl);
		revIndex.put(longUrl, key);
		return BASE_HOST + key;
	}

	// Decodes a shortened URL to its original URL.
	public static String decode(String shortUrl) {
		return index.get(shortUrl.replace(BASE_HOST, ""));
	}
}
