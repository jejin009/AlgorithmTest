package algo_2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1011_FLY_ME_TO_THE_ALPHA_CENTURI {

	static int x, y;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int dp[];
		
		for(int testcase = 1; testcase <= T; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			dp = new int[y+2];
			
			dp[3] = 3;
			dp[4] = 3;
			
			for(int i = 5; i <= y; i += 2) {
				dp[i] = dp[i-1]+1;
				dp[i+1] = dp[i-1]+1;
			}
			
			System.out.println(dp[y-x]);
			
			
			
//			int now = x;
//			int k = 0;
//			int cnt = 0;
//			while(true) {
//				
//			}
			
//			System.out.println(min);
		}
	}
//	private static void go(int now, int k, int cnt) {
//		System.out.println(now +" "+ k +" " + cnt);
//		if(now == y) {
//			min = Math.min(min, cnt);
//			return;
//		}
//		else if(cnt != 0 &&( now > y || now <= x)) {
//			return;
//		}
//		else {
//			go(now+k+1, k+1, cnt+1);
//			go(now+k, k, cnt+1);
//			go(now+k-1, k-1, cnt+1);
//		}
//	}
}
