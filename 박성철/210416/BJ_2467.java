import java.io.*;
import java.util.StringTokenizer;


// 백준 2467. 용액.
// 투 포인터.
public class BJ_2467 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = Integer.MAX_VALUE;
		int[] results = new int[2];
		int l=0, r=N-1;
		
		while(l != r) {
			int temp = arr[l] + arr[r];
			
			if(result > Math.abs(temp)) {
				result = Math.abs(temp);
				results[0] = arr[l];
				results[1] = arr[r];
				
				if(result == 0) {
					break;
				}
			}
			
			if(Math.abs(arr[l]) > Math.abs(arr[r])) {
				l++;
			}else {
				r--;
			}
		}
		
		System.out.println(results[0] + " " + results[1]);
		br.close();
	}
}
