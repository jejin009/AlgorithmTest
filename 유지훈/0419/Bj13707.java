import java.io.*;
import java.util.StringTokenizer;

public class Bj13707 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[][] dp = new long[N+1][K+1];
		for (int i = 0; i <= N; i++) {
			dp[i][1] = 1;
		}
		for (int i = 2; i <= K; i++) {
			long sum = 0;
			for (int j = 0; j <= N; j++) {
				sum += dp[j][i-1] % 1000000000;
				dp[j][i] = sum % 1000000000;
			}
		}
		
		System.out.println(dp[N][K]);
		
	}

}
