import java.io.*;
import java.util.*;


// 백준 14496. 그대, 그머가 되어.
// 다익스트라 문제.
public class BJ_14496 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<int[]>[] list = new LinkedList[N+1];
		int[] distance = new int[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new LinkedList<int[]>();
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			list[f].add(new int[] {t, 1});
			list[t].add(new int[] {f, 1});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		int start = from;
		pq.offer(new int[] {0, start});
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] current = pq.poll();
			int dist = current[0];
			int node = current[1];
			
			if(distance[node] < dist) {
				continue;
			}
			
			for(int[] next : list[node]) {
				int cost = dist + next[1];
				
				if(distance[next[0]] > cost) {
					distance[next[0]] = cost;
					pq.offer(new int[] {distance[next[0]], next[0]});
				}
			}
		}
		
		if(distance[to] == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(distance[to]);
		}
		br.close();
	}
}
