import java.io.*;
import java.util.*;

public class Bj9370 {

	static int N, M, U, S, G, H;
	static int[] se, ge, he;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //교차로(노드)
			M = Integer.parseInt(st.nextToken()); //도로(연결선)
			U = Integer.parseInt(st.nextToken()); //목적지 후보
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken()); //시작점
			G = Integer.parseInt(st.nextToken()); 
			H = Integer.parseInt(st.nextToken()); //G ~ H
			
			ArrayList<int[]>[] list = new ArrayList[N+1];
			for (int i = 0; i < N+1; i++) {
				list[i] = new ArrayList<>();
			}
			int gh = 0;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				if(from == G && to == H) gh = weight;
				else if(from == H && to == G) gh = weight;
				list[from].add(new int[] {to, weight});
				list[to].add(new int[] {from, weight});
			}
			int[] candidate = new int[U];
			for (int i = 0; i < U; i++) {
				candidate[i] = Integer.parseInt(br.readLine());
			}
			se = dijstra(S, list); //시작점에서 모든점까지 최단경로
			ge = dijstra(G, list); //g에서 모든점
			he = dijstra(H, list); //h에서 모든점
			
			ArrayList<Integer> res = new ArrayList<>();
			for (int i = 0; i < U; i++) {
				if(se[candidate[i]] == se[G] + gh + he[candidate[i]]) res.add(candidate[i]);
				else if(se[candidate[i]] == se[H] + gh + ge[candidate[i]]) res.add(candidate[i]);
			}
			Collections.sort(res);
			for (int i = 0,len = res.size(); i < len; i++) {
				sb.append(res.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	
	public static int[] dijstra(int start, ArrayList<int[]>[] list) {
		int[] distance = new int[N+1];
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
		
		return distance;
		
	}
}
