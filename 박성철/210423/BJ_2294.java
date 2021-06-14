import java.util.*;
import java.io.*;


// 백준 2294. 동전 2.
// DP.
public class BJ_2294 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N+1];
		for(int i=1; i<=N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(coins);
		
		int[][] dp = new int[N+1][K+1];
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=K; j++) {
				dp[i][j] = 123456789;
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				if(j / coins[i] > 0 && j % coins[i] == 0) {
					dp[i][j] = j / coins[i];
				}else if(j / coins[i] > 0 && !(j % coins[i] == 0)) {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i]] + 1);
				}else if(j < coins[i]) {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		int result = dp[N][K];
		if(result == 123456789) {
			result = -1;
		}
		System.out.println(result);
		br.close();
	}
}
