import java.io.*;
import java.util.*;

public class Bj3055 {

	static int R, C;
	static char[][] arr;
	static int sr, sc, er, ec;
	static boolean[][] visit;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int res;
	static ArrayList<int[]> list = new ArrayList<>();
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
				if(arr[i][j] == 'S') {
					sr = i;
					sc = j;
				} else if(arr[i][j] == 'D') {
					er = i;
					ec = j;
				} else if(arr[i][j] == '*') {
					list.add(new int[] {i, j});
				}
			}
		}
		
		res = 0;
		bfs();
		if(res == 0) System.out.println("KAKTUS");
		else System.out.println(res);
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		visit[sr][sc] = true;
		q.offer(new int[] {sr, sc, 0, 0});
		for (int i = 0,len = list.size(); i < len; i++) {
			q.offer(new int[] {list.get(i)[0], list.get(i)[1], 1}); //water
		}
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int type = temp[2];
			if(type == 0 && arr[temp[0]][temp[1]] == '*') continue;
			if(type == 0 && arr[temp[0]][temp[1]] == 'D') {
				res = temp[3];
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				if(nr < 0 || nc < 0 || nr >= R || nc >= C || arr[nr][nc] == '*' || arr[nr][nc] == 'X') continue;
				
				if(type == 1) {
					if(arr[nr][nc] == 'D') continue;
					else {
						arr[nr][nc] = '*';
						q.offer(new int[] {nr, nc, 1});
					}
				} else {
					if(!visit[nr][nc]) {
						q.offer(new int[] {nr, nc, 0, temp[3]+1});
						visit[nr][nc] = true;
					}
				}
			}
		}
	}

}
