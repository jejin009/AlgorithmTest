package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2252 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<Integer, LinkedList<Integer>> maps = new HashMap<>();
		int[] indegree = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			if (!maps.containsKey(from)) {
				LinkedList<Integer> list = new LinkedList<>();
				maps.put(from, list);
			}

			maps.get(from).add(to);
			indegree[to]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}

		while (true) {
			if (queue.size() == 0)
				break;

			int from = queue.poll();

			System.out.print(from + " ");

			if (maps.containsKey(from)) {
				for (int to : maps.get(from)) {
					indegree[to]--;
					if (indegree[to] == 0)
						queue.add(to);
				}
			}
		}
	}

}
