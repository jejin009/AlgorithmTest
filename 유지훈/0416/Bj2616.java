import java.io.*;
import java.util.StringTokenizer;

public class Bj2616 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] sum = new int[N+1];
		for (int i = 1; i <= N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + temp;
		}
		int[][] dp = new int[N+1][4];
		for (int i = 1; i <= 3; i++) {
			for (int j = i * M; j <= N; j++) {
				int s = sum[j] - sum[j - M];
				dp[j][i] = Math.max(dp[j-1][i], dp[j-M][i-1] + s);
			}
		}
		System.out.println(dp[N][3]);
	}

}
