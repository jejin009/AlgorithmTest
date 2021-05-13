import java.io.*;
import java.util.*;


// 백준 2075. N번째 큰 수.
// 우선순위 큐.
public class BJ_2075 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
		}
		
		int result = 0;
		while(N > 0) {
			result = pq.poll();
			N--;
		}
		
		System.out.println(result);
		br.close();
	}
}
