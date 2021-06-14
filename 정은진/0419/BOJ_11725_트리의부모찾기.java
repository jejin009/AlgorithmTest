package algo_0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {

	static ArrayList<Integer>[] list;
	static boolean visited[];
	static int parents[];
	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		parents = new int[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < N -1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		q.offer(1);
		int size = list[1].size();
		
		while(!q.isEmpty()) {
			int parent = q.poll();
			size = list[parent].size();
			for(int i = 0; i < size; i++) {
				int v = list[parent].get(i);
				if(!visited[v]) {
					q.offer(v);
					parents[v] = parent;
					visited[v] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i <= N; i++)
			sb.append(parents[i]).append("\n");
		
		System.out.println(sb.toString());
	}
}
