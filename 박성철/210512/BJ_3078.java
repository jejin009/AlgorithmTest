import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


// 백준 3078. 좋은 친구.
// 슬라이딩 윈도우 (투 포인터)
public class BJ_3078 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[N];
		int[] lenArr = new int[21];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		int start = 0;
		int end = 0;
		
		long result = 0;
		while(end < N) {
			if(end > start+K) {
				lenArr[arr[start++].length()]--;
			}
			result += lenArr[arr[end++].length()]++;
//			System.out.println(result);
//			System.out.println(Arrays.toString(lenArr));
		}
		
		System.out.println(result);
		br.close();
	}
}
