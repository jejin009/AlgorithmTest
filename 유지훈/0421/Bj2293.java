import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj2293 {

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
		for (int i = 1; i <= N; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				if(i-coin[j-1] >= 0) {
					dp[j][i] = dp[j-1][i] + dp[j][i-coin[j-1]];
				} else {
					dp[j][i] = dp[j-1][i];
				}
			}
		}
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(dp[N][K]);
	}

}
