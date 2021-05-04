package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 백준_1967 {
	public static class Node{
		private int idx;
		private int val;
		
		public Node(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}
	private static LinkedList<Node>[] adjlist;
	private static int N;
	private static int max = 0;
	private static int maxNode = 0;
	private static boolean visited[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		adjlist = new LinkedList[N+1];
		
		for(int i = 0; i <= N; i++) {
			adjlist[i] = new LinkedList<>();
		}
		
		// 인접 리스트 데이터 삽입
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adjlist[a].add(new Node(b, cost));
			adjlist[b].add(new Node(a, cost));
		}
		
		visited = new boolean[N+1];
		visited[1] = true;
		dfs(1, 0);
		
		Arrays.fill(visited, false);
		visited[maxNode] = true;
		max = 0;
		dfs(maxNode, 0);
		System.out.println(max);
		
	}
	
	
	public static void dfs(int start, int sum) {
		if(max < sum) {
			max = sum;
			maxNode = start;
		}
		
		for(int i = 0; i < adjlist[start].size(); i++) {
			int to = adjlist[start].get(i).idx;
			int cost = adjlist[start].get(i).val;
			if(!visited[to]) {
				visited[to] = true;
				dfs(to, sum + cost);
			}
		}
	}
}
