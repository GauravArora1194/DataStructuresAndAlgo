package com.interview.walmart;

public class ModulusOfHexaDecimalNumbers {

	public static void main(String[] args) {

		String n = "3E8";
		String k = "13";

		// n % k

		int N = Integer.parseInt(n, 16);
		System.out.println(" N : " + N);
		System.out.println(" N from function: " + hexToInt(n));
		int K = Integer.parseInt(k, 16);

		System.out.println(Integer.toHexString(N % K));
	}

	public static int hexToInt(String hex) {

		char[] c = hex.toCharArray();
		int ans = 0;
		int base = 1;

		for (int i = c.length - 1; i >= 0; i--) {

			char j = c[i];

			if (j >= '0' && j <= '9') {
				ans += base * (j - '0');
			} else {
				ans += base * ((j - 'A') + 10);
			}

			base = base * 16;
		}

		return ans;
	}
}
