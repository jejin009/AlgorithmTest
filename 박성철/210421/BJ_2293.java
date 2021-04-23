import java.io.*;
import java.util.StringTokenizer;


// 백준 2293. 동전1.
// DP.
public class BJ_2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coins = new int[N+1];
		for(int i=1; i<=N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] dp = new int[N+1][K+1];
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=K; j++) {
				if(j==0) {
					dp[i][j] = 1;
				}else if(coins[i] > j) {
					dp[i][j] = dp[i-1][j];
				}else if(coins[i] <= j){
					dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
				}
			}
		}
		
		System.out.println(dp[N][K]);
		br.close();
	}
}
