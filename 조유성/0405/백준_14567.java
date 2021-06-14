package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_14567 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt[] = new int[N + 1];
		Arrays.fill(cnt, 1);
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());
			q.add(new int[] {before, after});
		}
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int before = cur[0];
			int after = cur[1];
			cnt[after] = Math.max(cnt[after], cnt[before] + 1);
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(cnt[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
