import java.io.*;
import java.util.*;

public class Bj14497 {

	static int N, M;
	static int[][] arr;
	static int res = 0;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken())-1;
		int y1 = Integer.parseInt(st.nextToken())-1;
		int x2 = Integer.parseInt(st.nextToken())-1;
		int y2 = Integer.parseInt(st.nextToken())-1;
		arr[x1][y1] = 2; //주난
		arr[x2][y2] = 3; //초코바
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				if(i == x1 && j == y1) continue;
				if(i == x2 && j == y2) continue;
				arr[i][j] = temp.charAt(j) - '0';
			}
		}
		
		bfs(x1, y1);
		System.out.println(res);
	}
	private static void bfs(int x1, int y1) {
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2]-o2[2];
			}
		});
		q.offer(new int[] {x1, y1, 0});
		visit[x1][y1] = true;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			int r = temp[0];
			int c = temp[1];
			int time = temp[2];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc]) continue;
				
				if(arr[nr][nc] == 0) {
					q.offer(new int[] {nr, nc, time});
					visit[nr][nc] = true;
				} else if(arr[nr][nc] == 1) {
					q.offer(new int[] {nr, nc, time+1});
					visit[nr][nc] = true;
				} else {
					res = time+1;
					return;
				}
			}
		}
	}

	
	
}
