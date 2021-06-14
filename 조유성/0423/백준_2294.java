package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_2294 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[10001];
		Arrays.fill(dp, 10001);
		
		for(int i = 0; i < N; i++) {
			int coin = Integer.parseInt(br.readLine());
			if(coin <= 10000) {
				dp[coin] = 1;
			}
		}
		
		for(int i = 1; i <= K; i++) {
			for(int a = 1; a <= i / 2; a++) {
				if(dp[a] != 10001 && dp[i-a] != 10001) {
					dp[i] = Math.min(dp[i], dp[a] + dp[i-a]);
				}
			}
		}
		
		if(dp[K] == 10001) {
			System.out.println(-1);
		}else {
			System.out.println(dp[K]);
		}
	}

}
