import java.io.*;
import java.util.StringTokenizer;

public class Bj1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int left=0, right=0;
		long sum = arr[0];
		int res = Integer.MAX_VALUE;
		while(true) {
			if(left >= N || right >= N || left > right) break;
			if(sum >= M) {
				res = Math.min(res, right-left+1);
				sum -= arr[left++];
			} else {
				right++;
				if(right >= N) break;
				sum += arr[right];
			}
		}
		if(res == Integer.MAX_VALUE) res = 0;
		System.out.println(res);
	}

}
