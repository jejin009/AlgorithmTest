import java.io.*;
import java.util.*;

public class Bj1967 {

	static int res = Integer.MIN_VALUE;
	static Node[] tree;
	static boolean[] visit;
	static int[] distance;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		tree = new Node[N+1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new Node(i);
		}
		visit = new boolean[N+1];
		distance = new int[N+1];
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			tree[from].list.add(new int[] {to, weight});
			tree[to].list.add(new int[] {from, weight});
			
		}
		
		dijstra(1);
		int max = Integer.MIN_VALUE;
		int midx = 0;
		for (int i = 1; i <= N; i++) {
			if(distance[i] > max) {
				midx = i;
				max = distance[i];
			}
		}
		visit = new boolean[N+1];
		dijstra(midx);
		max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, distance[i]);
		}
		System.out.println(max);
	}

	public static class Node{
		int num;
		ArrayList<int[]> list = new ArrayList<>();
		protected Node(int num) {
			super();
			this.num = num;
		}
		
	}
	
	public static void dijstra(int start) {
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});
		q.offer(new int[] {start, distance[start]});
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			if(visit[temp[0]] || distance[temp[0]] < temp[1]) continue;
			visit[temp[0]] = true;
			
			for (int[] n : tree[temp[0]].list) {
				if(!visit[n[0]] && distance[n[0]] > temp[1] + n[1]) {
					distance[n[0]] = temp[1] + n[1];
					q.offer(new int[] {n[0], distance[n[0]]});
				}
			}
		}
	}
	
}
