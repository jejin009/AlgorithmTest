package algo_2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14497_주난의난 {

	static class Room {
		int r;
		int c;
		int weight;

		public Room(int r, int c, int weight) {
			super();
			this.r = r;
			this.c = c;
			this.weight = weight;
		}
	}

	static PriorityQueue<Room> q = new PriorityQueue<Room>();
	static int classroom2[][];
	static char classroom[][];
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		br.readLine();
		classroom2 = new int[N][M];
		classroom = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char temp = str.charAt(j);
				classroom[i][j] = temp;
				classroom2[i][j] = temp - '0';
				if (temp == '*') {
					classroom2[i][j] = 0;
					q.offer(new Room(i, j, 0));
				}
				if (temp == '#') {
					classroom2[i][j] = -2;
					q.offer(new Room(i, j, 0));
				}
			}
		}

		bfs();
	}

	private static void bfs() {
		boolean visited[][] = new boolean[N][M];
		int di[] = { -1, 0, 1, 0 };
		int dj[] = { 0, 1, 0, -1 };
		int answer = 0;
		
		while (!q.isEmpty()) {
			Room room = q.poll();

			for (int i = 0; i < 4; i++) {
				int nextr = room.r + di[i];
				int nextc = room.r + dj[i];
				if (nextr >= 0 && nextr < N && nextc >= 0 && nextc < M && !visited[nextr][nextc]) {
					if (classroom[nextr][nextc] == 1) {
						if (!visited[nextr][nextc]) {
							classroom2[nextr][nextc] = classroom2[room.r][room.c] + 1;
							q.offer(new Room(nextr, nextc, room.weight + 1));
							visited[nextr][nextc] = true;
						}else {
							if(classroom[nextr][nextc]>room.weight + 1)
							classroom2[nextr][nextc] = room.weight + 1;							
						}
						continue;
					} else if (classroom[nextr][nextc] == 0) {
						if (!visited[nextr][nextc]) {
							classroom2[nextr][nextc] = room.weight;
							q.offer(new Room(nextr, nextc, room.weight));
							visited[nextr][nextc] = true;
						}else {
							if(classroom[nextr][nextc]>room.weight)
							classroom2[nextr][nextc] = room.weight;							
						}
					} else if (classroom[nextr][nextc] == -2) {
						answer = room.weight+1;
						q.clear();
					}
				}
			}
			
		}
		System.out.println(answer);
	}
}
