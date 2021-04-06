package com.ssafy.day0405;

import java.io.*;
import java.util.*;

// 백준 14567. 선수과목.
// 위상 정렬.
public class BJ_14567 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] preNode = new int[N+1];
		int[] result = new int[N+1];
		
		List<Integer> resultRoute = new ArrayList<Integer>();
		
		List<Integer>[] listArr = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			listArr[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			listArr[from].add(to);
			preNode[to] += 1;
		}
		
		Deque<Integer> dq = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			if(preNode[i] == 0) {
				dq.offer(i);
			}
		}
		
		int layer = 1;
		int count = 0;
		while(!dq.isEmpty()) {
			int size = dq.size();
			
			for(int i=0; i<size; i++) {
				int node = dq.poll();
				count++;
				
				resultRoute.add(node);
				result[node] = layer;
				
				for(int next : listArr[node]) {
					preNode[next] -= 1;
					
					if(preNode[next] == 0) {
						dq.offer(next);
					}
				}
			}
			layer++;
		}
		
		for(int i=1; i<=N; i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(count);
		
		for(int i : resultRoute) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.println(sb.toString());
		br.close();
	}
}
