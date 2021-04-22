import java.io.*;
import java.util.StringTokenizer;

public class Bj2294 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int[][] dp = new int[N+1][K+1];
		for (int i = 1; i <= K; i++) {
			dp[0][i] = -1;
		}
		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				if(i-coin[j-1] >= 0) {
					if(dp[j-1][i] == -1 && dp[j][i-coin[j-1]]+1 != 0) dp[j][i] = dp[j][i-coin[j-1]]+1;
					else if(dp[j][i-coin[j-1]]+1 == 0 && dp[j-1][i] != -1) dp[j][i] = dp[j-1][i];
					else if(dp[j][i-coin[j-1]]+1 == 0 && dp[j-1][i] == -1) dp[j][i] = -1;
					else dp[j][i] = Math.min(dp[j-1][i], dp[j][i-coin[j-1]]+1);
				} else {
					dp[j][i] = dp[j-1][i];
				}
			}
		}
//		for (int i = 0; i <= N; i++) {
//			for (int j = 0; j <= K; j++) {
//				System.out.print(dp[i][j] + "\t");
//			}
//			System.out.println();
//		}
		System.out.println(dp[N][K]);
	}

}
