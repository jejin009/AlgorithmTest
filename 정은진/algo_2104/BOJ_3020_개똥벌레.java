package algo_2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3020_개똥벌레 {

	static int N, H;
	static int obs[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		obs = new int[N];
		for(int i = 0; i <N; i++) {
			obs[i] = Integer.parseInt(br.readLine());
		}
		
		int min = Integer.MAX_VALUE;
		int ans = 0;
		for(int i = 1; i <= H; i++) {
			int sum = 0;
			for(int j = 0; j < N; j++) {
				if(j%2 == 0 && obs[j] >= i) sum++;
				else if(j%2 == 1 && H-obs[j] < i) sum++;
				if(sum > min) break;
			}
			if(sum < min) {
				min = sum;
				ans = 1;
			}else if(sum == min) ans++;
		}
		System.out.println(min + " " +ans);
	}
}
