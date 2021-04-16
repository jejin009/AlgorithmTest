import java.io.*;
import java.util.StringTokenizer;

public class Bj2467 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = N-1;
		int resL = 0, resR = 0;
		int min = Integer.MAX_VALUE;
		while(true) {
			if(left==right) break;
			int sum = arr[left] + arr[right];
			if(Math.abs(sum) <= min) {
				min = Math.min(min, Math.abs(sum));
				resL = arr[left];
				resR = arr[right];
			}
			if(sum < 0) {
				left++;
			} else {
				right--;
			}
			
		}
		System.out.println(resL + " " + resR);
	}

}
