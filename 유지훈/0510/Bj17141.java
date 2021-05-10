import java.io.*;
import java.util.*;

public class Bj17141 {

	static int N, M;
	static int arr[][];
	static int all;
	static int res;
	static ArrayList<int[]> list = new ArrayList<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		all = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0) all++;
				else if(arr[i][j] == 2) {
					list.add(new int[] {i, j});
					arr[i][j] = 0;
				}
			}
		}
		all = all + list.size(); 
		res = Integer.MAX_VALUE;
		combination(0, 0, new int[M]);
		if(res == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(res);
	}

	public static void combination(int startidx, int cnt, int result[]) {
		if(cnt == M) {
			int temp[][] = new int[N][N];
		    
	        for(int i=0; i< N; i++){
	            System.arraycopy(arr[i], 0, temp[i], 0, N);
	        }
			int time = bfs(result, temp);
			if(time != -1) res = Math.min(res, time);
//			System.out.println(time);
			return;
		}
		
		for (int i = startidx,len = list.size(); i < len; i++) {
			result[cnt] = i;
			combination(i+1, cnt+1, result);
		}
	}

	private static int bfs(int[] result, int[][] map) {
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < M; i++) {
			int[] l = list.get(result[i]);
			q.offer(new int[] {l[0], l[1], 0});
			map[l[0]][l[1]] = 2;
		}
		int cnt = 0;
		int time = 0;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			cnt++;
			if(q.isEmpty()) time = temp[2];
			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1 || map[nr][nc] == 2) continue;
				q.offer(new int[] {nr, nc, temp[2]+1});
				map[nr][nc] = 2;
			}
		}
		if(cnt == all) return time;
		else return -1;
	}
}
