import java.io.*;
import java.util.*;

public class Bj1248 {

	static int[] res;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken())-1;
		res = new int[N];
		ArrayList<int[]>[] list = new ArrayList[N];
		ArrayList<int[]>[] back = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
			back[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new int[] {to, weight});
			back[to].add(new int[] {from, weight});
		}
		
		dijstra(X, list);
		dijstra(X, back);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, res[i]);
		}
		System.out.println(max);
	}

	public static void dijstra(int start, ArrayList<int[]>[] list) {
		int[] distance = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1]-o2[1];
			}
		});
		pq.offer(new int[] {start, 0});
		distance[start] = 0;
		while(!pq.isEmpty()) {
			int[] temp = pq.poll();
			int node = temp[0];
			int weight = temp[1];
			if(distance[node] < weight) continue;
			
			for (int[] i : list[node]) {
				if(distance[i[0]] > i[1]+weight) {
					distance[i[0]] = i[1]+weight;
					pq.offer(new int[] {i[0], distance[i[0]]});
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			res[i] += distance[i];
		}
	}
}
