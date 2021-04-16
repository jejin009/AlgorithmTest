package algo_2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {

	static int liq[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		liq = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			liq[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int num[] = new int[2];
		int l = 0;
		int r = N-1;		
		sum = Math.abs(liq[l] + liq[r]);
		num[0] = liq[l];
		num[1] = liq[r];
		min = Math.abs(sum);
		
		while(l < r) {
			sum = Math.abs(liq[l] + liq[r]);
			if(min > Math.abs(sum)){
				num[0] = liq[l];
				num[1] = liq[r];
				min = Math.abs(sum);
			}
			if(liq[l] < 0 && liq[r] > 0) {
				if(Math.abs(liq[l]) > Math.abs(liq[r])) {
					l++;
				}else if(Math.abs(liq[l]) < Math.abs(liq[r])) {
					r--;
				}else {
					num[0] = liq[l];
					num[1] = liq[r];
					break;
				}
			}else if(liq[l] < 0 && liq[r] <= 0) {
				l++;
			}else {
				r--;
			}
		}
		System.out.println(num[0] + " " + num[1]);
	}
}
