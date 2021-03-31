import java.io.*;
import java.util.*;

// 백준 13549. 숨바꼭질3.
// 다익스트라.
public class BJ_13549 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[100001];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		int[] start = {0, N};
		pq.offer(start);
		distance[N] = 0;
		
		while(!pq.isEmpty()) {
			int[] current = pq.poll();
			int dist = current[0];
			int node = current[1];
			
			if(distance[node] < dist) {
				continue;
			}
			
			int multiple = node * 2;
			if(multiple <= 100000 && node != 0) {
				if(distance[multiple] > dist) {
					distance[multiple] = dist;
					pq.offer(new int[] {dist, multiple});
				}
			}
			
			if(node+1 <= 100000) {
				if(distance[node+1] > dist + 1) {
					distance[node+1] = dist+1;
					pq.offer(new int[] {dist+1, node+1});
				}
			}
			
			if(node-1 >= 0) {
				if(distance[node-1] > dist + 1) {
					distance[node-1] = dist+1;
					pq.offer(new int[] {dist+1, node-1});
				}
			}
		}
		for(int i=0; i<=K+3; i++) {
			System.out.print(distance[i] + " ");
		}
		System.out.println("---------");
		
		
		System.out.println(distance[K]);
		br.close();
	}
}
