package algo_2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {

	static int N, M;
	static ArrayList<Integer>[] arr;
	static int[] into;
	static Queue<Integer> q = new LinkedList<Integer>();
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N + 1];
		into = new int[N + 1];
		answer = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			arr[from].add(to);
			into[to]++;
		}

		for (int i = 1; i <= N; i++) {
			if (into[i] == 0) {
				q.offer(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int next = q.poll();
				
				sb.append(next).append(" ");
				
				for(int j = 0; j < arr[next].size(); j++) {
					int temp = arr[next].get(j);
					into[temp]--;
					if(into[temp] == 0)
						q.add(temp);
				}
			}
		}
	
		
		System.out.println(sb.toString());
	}
}
