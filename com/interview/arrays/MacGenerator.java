package com.interview.arrays;

import java.math.BigInteger;

public class MacGenerator {
	
	public static void main(String[] args) {
		
		System.out.println("OUTPUT : " + getMacValue("0188441401283019117481845PAX"));
		
	}

	public static String getMacValue(String data) {
		System.out.println("Raw Mac data:: " + data);
		try {
			data = toHex(data);
			data = addPaddingInLast(data);
			System.out.println("Padded Mac data:: " + data);
			return data;

		} catch (Exception e) {

		}

		return null;
	}

	public static String toHex(String arg) {
		return String.format("%040x", new BigInteger(1, arg.getBytes(/* YOUR_CHARSET? */)));
	}

	public static String addPaddingInLast(String str) {
		String HEXES = "0123456789ABCDEF";
		int pad = (int) (8 * Math.ceil((double) str.length() / (2 * 8)));
		// Make size multiple of 2
		int mod = str.length() % 2;
		if (mod > 0) {
			str = "0" + str;
		}
		byte[] exp = hexStringToByteArray(str);
		byte[] finalExp = new byte[pad];
		System.arraycopy(exp, 0, finalExp, 0, exp.length);
		final StringBuilder hex = new StringBuilder(2 * finalExp.length);
		for (final byte b : finalExp) {
			hex.append(HEXES.charAt((b & 0xF0) >> 4)).append(HEXES.charAt((b & 0x0F)));
		}
		return hex.toString();
	}

	private static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

}
