package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_4179 {
	private static int R;
	private static int C;
	private static int dr[] = {-1, 0, 1, 0};
	private static int dc[] = {0, 1, 0, -1};
	private static ArrayList<int[]> fires;
	
	public static void main(String[] args) throws IOException{
		// bfs로 풀이. 먼저 불이 퍼지고 그 다음에 지훈이가 움직이도록 구현.
		// 불이 방문한 곳(visitedFire)은 지훈이가 방문 하지 못하도록 조건 설정.
		// 맵 가장자리에 도착 시 time + 1로 리턴
		// 큐 빌때까지 해서 도착 못하면 impossible 출력.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		int jihunR = 0, jihunC = 0;
		fires = new ArrayList();
		
		for(int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
			for(int c = 0; c < C; c++) {
				if(map[r][c] == 'F') {
					fires.add(new int[] {r, c});
				}else if(map[r][c] == 'J') {
					jihunR = r;
					jihunC = c;
				}
			}
		}
		
		bfs(jihunR, jihunC, map);
		
		
	}
	public static void bfs(int jihunR, int jihunC, char[][] map) {
		boolean[][] visitedJ = new boolean[R][C];
		boolean[][] visitedF = new boolean[R][C];
		Queue<int[]> q = new LinkedList<>();
		
		for(int[] fire : fires) {
			visitedF[fire[0]][fire[1]] = true;
			q.offer(new int[] {fire[0], fire[1], 0, 0});
		}
		
		visitedJ[jihunR][jihunC] = true;
		q.offer(new int[] {jihunR, jihunC, 0, 1});
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			// 불
			if(cur[3] == 0) {
				for(int k = 0; k < 4; k++) {
					int nextR = cur[0] + dr[k];
					int nextC = cur[1] + dc[k];
					if(0 <= nextR && 0 <= nextC && nextR < R && nextC < C) {
						if(!visitedF[nextR][nextC] && map[nextR][nextC] != '#') {
							visitedF[nextR][nextC] = true;
							q.offer(new int[] {nextR, nextC, cur[2] + 1, cur[3]});
						}
					}
				}
			}
			// 지훈
			else {
				if(cur[0] == 0 || cur[0] == R-1 || cur[1] == 0 || cur[1] == C-1) {
					System.out.println(cur[2] + 1);
					return;
				}
				for(int k = 0; k < 4; k++) {
					int nextR = cur[0] + dr[k];
					int nextC = cur[1] + dc[k];
					if(0 <= nextR && 0 <= nextC && nextR < R && nextC < C) {
						if(!visitedJ[nextR][nextC] && !visitedF[nextR][nextC] && map[nextR][nextC] != '#') {
							visitedJ[nextR][nextC] = true;
							q.offer(new int[] {nextR, nextC, cur[2] + 1, cur[3]});
						}
					}
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}

}
