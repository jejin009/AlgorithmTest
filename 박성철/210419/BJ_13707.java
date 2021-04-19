package com.ssafy.day0419;

import java.io.*;
import java.util.StringTokenizer;

// 백준 13707. 합분해2
// DP.
public class BJ_13707 {
	
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][K+1];
		for(int i=0; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				if(j == 1) {
					dp[i][j] = 1;
				}else if(i == 0 && j > 0) {
					dp[i][j] = 1;
				}else {
					dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000000;
				}
			}
		}
		System.out.println(dp[N][K]);
		br.close();
	}
}
