package com.ssafy.day0407;

import java.io.*;
import java.util.*;

// 백준 2252. 줄세우기.
// 위상 정렬.
public class BJ_2252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[N+1];
		
		List<Integer>[] listArr = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			listArr[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			listArr[from].add(to);
			indegree[to]++;
		}
		
		Deque<Integer> result = new LinkedList<Integer>();
		Deque<Integer> dq = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) {
				dq.add(i);
			}
		}
		
		while(!dq.isEmpty()) {
			int current = dq.poll();
			
			result.offer(current);
			
			for(int next : listArr[current]) {
				indegree[next]--;
				if(indegree[next] == 0) {
					dq.offer(next);
				}
			}
		}
		
		for(int i : result) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
