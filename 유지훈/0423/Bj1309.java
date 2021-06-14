import java.io.*;

public class Bj1309 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		dp[0] = 1;
		dp[1] = 3;
		for (int i = 2; i <= N; i++) {
			dp[i] = (2*dp[i-1] + dp[i-2]) % 9901;
		}
		
		System.out.println(dp[N] % 9901);
	}

}
