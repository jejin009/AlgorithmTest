package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N + 2];
		dp[0] = 3;
		dp[1] = 7;

		for (int i = 0; i < N; i++) {
			dp[i + 2] = (dp[i + 1] * 2 + dp[i]) % 9901;
		}
		System.out.println(dp[N-1]);
	}

}
