package algo_2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3020_개똥벌레2 {

	static int N, H;
	static int obstop[];
	static int obsdown[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		obstop = new int[H+1];
		obsdown = new int[H+1];
		int topmax = 0;
		int downmax = 0;
		for(int i = 0; i <N; i+=2) {
			int temp = Integer.parseInt(br.readLine());
			obstop[temp]++;
			temp = Integer.parseInt(br.readLine());
			obsdown[temp]++;
		}
		
		for(int i = H; i > 0; i--) {
			obstop[i-1] = obstop[i-1]+obstop[i];
			obsdown[i-1] = obsdown[i-1]+obsdown[i];
		}
		
		int min = Integer.MAX_VALUE;
		int ans = 0;
		for(int i = 1; i <= H; i++) {
			
			int sum = obstop[i]+obsdown[H-i+1];
			
			if(sum < min) {
				min = sum;
				ans = 1;
			}else if(sum == min) ans++;
		}
		System.out.println(min + " " +ans);
	}
}
