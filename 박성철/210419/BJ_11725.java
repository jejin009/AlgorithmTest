package com.ssafy.day0419;

import java.io.*;
import java.util.*;

// 백준 11725. 트리의 부모 찾기.
// BFS.
public class BJ_11725 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		List<Integer>[] adjList = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		int[] parents = new int[N+1];
		
		Deque<int[]> dq = new LinkedList<int[]>();
		
		for(int node : adjList[1]) {
			dq.offer(new int[] {1, node});
			parents[node] = 1;
		}
		
		while(!dq.isEmpty()) {
			int[] current = dq.poll();
			int from = current[0];
			int to = current[1];
			
			for(int next : adjList[to]) {
				if(parents[next] == 0) {
					parents[next] = to;
					dq.offer(new int[] {to, next});
				}
			}
		}
		
		for(int i=2; i<=N; i++) {
			sb.append(parents[i]).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
