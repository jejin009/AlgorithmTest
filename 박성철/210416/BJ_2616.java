package com.ssafy.day0416;

import java.io.*;
import java.util.StringTokenizer;


// 백준 2616. 소형기관차.
// DP, 누적합
public class BJ_2616 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int trainLength = Integer.parseInt(st.nextToken());
		int[] trains = new int[trainLength+1];
		int[] prefixSum = new int[trainLength+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=trainLength; i++) {
			trains[i] = Integer.parseInt(st.nextToken());
			prefixSum[i] = trains[i] + prefixSum[i-1];
		}
		
		int subTrainLength = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[3+1][trainLength+1];
		
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=trainLength; j++) {
				if(j < subTrainLength) {
					dp[i][j] = dp[i][j-1];
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-subTrainLength] + prefixSum[j] - prefixSum[j-subTrainLength]);
				}
			}
		}
		
		System.out.println(dp[3][trainLength]);
		br.close();
	}
}
