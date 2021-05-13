import java.io.*;
import java.util.*;


// 백준 3055. 탈출.
// BFS.
public class BJ_3055 {
	static class Pos {
		int r;
		int c;
		int time;
		boolean type;
		
		public Pos(int r, int c, int time, boolean type) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.type = type;
		}
	}
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] field = new char[R][C];
		boolean [][] visited = new boolean[R][C];
		boolean [][] sinked = new boolean[R][C];
		
		List<Pos> waters = new ArrayList<Pos>();
		
		Pos start = null;
		for(int i=0; i<R; i++) {
			field[i] = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				if(field[i][j] == 'S') {
					start = new Pos(i, j, 0, true);
					visited[i][j] = true;
				}else if(field[i][j] == '*') {
					waters.add(new Pos(i, j, 0, false));
					sinked[i][j] = true;
				}
			}
		}
		
		Deque<Pos> dq = new LinkedList<Pos>();
		dq.offer(start);
		
		for(Pos water : waters) {
			dq.offer(water);
		}
		
		int result = -1;
		while(!dq.isEmpty()) {
			Pos current = dq.poll();
			int r = current.r;
			int c = current.c;
			int time = current.time;
			boolean type = current.type;
			
			if(field[r][c] == 'D' && type) {
				result = time;
				break;
			}
			
			if(type && sinked[r][c]) {
				continue;
			}
			
			for(int dir=0; dir<4; dir++) {
				int ar = r + dr[dir];
				int ac = c + dc[dir];
				
				if(ar < 0 || ar >= R || ac < 0 || ac >= C || field[ar][ac] == 'X' || sinked[ar][ac]) {
					continue;
				}
				
				if(type && visited[ar][ac]) {
					continue;
				}else if(!type && field[ar][ac] == 'D') {
					continue;
				}
				
			
				dq.offer(new Pos(ar, ac, time+1, type));
				visited[ar][ac] = true;
				if(!type) {
					sinked[ar][ac] = true;
				}
			}
		}
		
		if(result == -1) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(result);
		}
		
		br.close();
	}
}
