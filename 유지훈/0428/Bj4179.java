import java.io.*;
import java.util.*;

public class Bj4179 {

	static int R, C;
	static ArrayList<int[]> fire = new ArrayList<>();
	static int sR, sC;
	static char[][] arr;
	static boolean[][] visit;
	static int res = -1;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
				if(arr[i][j] == 'J') {
					sR = i;
					sC = j;
				} else if(arr[i][j] == 'F') fire.add(new int[] {i, j});
			}
		}
		bfs();
		if(res == -1) {
			System.out.println("IMPOSSIBLE");
		} else System.out.println(res);
	}
	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		for(int[] f : fire) {
			q.offer(new int[] {f[0], f[1], 1});
		}
		q.offer(new int[] {sR, sC, 0, 0}); //지훈
		visit[sR][sC] = true;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int type = temp[2];
			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= R || nc >= C) {
					if(type == 0) {
						res = temp[3]+1;
						return;
					}
					continue;
				}
				if(arr[nr][nc] == '#') continue;
				
				if(type == 0) {
					if(arr[nr][nc] == '.' && !visit[nr][nc]) {
						q.offer(new int[] {nr, nc, type, temp[3]+1});
						visit[nr][nc] = true;
					}
				} else {
					if(arr[nr][nc] != 'F') {
						q.offer(new int[] {nr, nc, type});
						arr[nr][nc] = 'F';
					}
				}
			}
		}
	}

	
}
