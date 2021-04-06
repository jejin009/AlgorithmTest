package study;

import java.io.*;
import java.util.*;

public class 백준_14497 {
	static int N;
	static int M;
	static int x1;
	static int x2;
	static int y1;
	static int y2;
	static char map[][];
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		st = new StringTokenizer(br.readLine());
		x1 = Integer.parseInt(st.nextToken()) - 1;
		y1 = Integer.parseInt(st.nextToken()) - 1;
		x2 = Integer.parseInt(st.nextToken()) - 1;
		y2 = Integer.parseInt(st.nextToken()) - 1;

		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
		}
		bfs();
	}

	public static void bfs() {		
		// 그냥 큐는 안돼고 왜 우선순위 큐여야 하는지 질문
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		boolean visited[][] = new boolean[N][M];

		q.offer(new int[] { x1, y1, 0});
		visited[x1][y1] = true;

		while (!q.isEmpty()) {
			int cur[] = q.poll();
			for (int k = 0; k < 4; k++) {
				int nextR = cur[0] + dr[k];
				int nextC = cur[1] + dc[k];
				if (0 <= nextR && 0 <= nextC && nextR < N && nextC < M && !visited[nextR][nextC]) {
					visited[nextR][nextC] = true;
					if(map[nextR][nextC] == '1') {
						q.offer(new int[] {nextR, nextC, cur[2] + 1});
					}else if(map[nextR][nextC] == '0') {
						q.offer(new int[] {nextR, nextC, cur[2]});
					}else if(map[nextR][nextC] == '#') {
						System.out.println(cur[2] + 1);
						return;
					}
				}
			}
		}
	}
}
