import java.io.*;
import java.util.StringTokenizer;


// 백준 1806. 부분합.
// 투 포인터.
public class BJ_1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int l = 0, r = 0, sum = 0;
		int result = Integer.MAX_VALUE;
		
		while(true) {
			if(r == N) {
				while(sum >= S) {
					result = Math.min(result, r-l);
					sum -= arr[l++];
				}
				break;
			}
			
			if(sum < S) {
				sum += arr[r++];
			}else {
				result = Math.min(result, r-l);
				sum -= arr[l++];
			}
		}
		
		if(result == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(result);
		}
		br.close();
	}
}
