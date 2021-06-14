import java.io.*;
import java.util.*;


// 백준 17141. 연구소 2.
// 조합, BFS
public class BJ_17141 {
	static class Pos {
		int r;
		int c;
		int time;
		
		public Pos(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static List<Integer> cases = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] field = new int[N][N];
		List<Pos> viruses = new ArrayList<Pos>();
		
		int area = N*N;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				if(field[i][j] == 2) {
					viruses.add(new Pos(i, j, 0));
				}else if(field[i][j] == 1) {
					area -= 1;
				}
			}
		}
		int numVirus = viruses.size();
		int result = Integer.MAX_VALUE;
		
		combination(0, 0, numVirus, M);
		
		Deque<Pos> dq = new LinkedList<Pos>();
		
		for(int comb : cases) {
			int wasteTime = 0;
			int count = 0;
			
			boolean[][] visited = new boolean[N][N];
			
			dq.clear();
			
			for(int i=0; i<numVirus; i++) {
				if((comb & 1 << i) != 0) {
					Pos p = viruses.get(i);
					dq.offer(p);
					visited[p.r][p.c] = true;
				}
			}
			
			while(!dq.isEmpty()) {
				Pos current = dq.poll();
				int r = current.r;
				int c = current.c;
				int time = current.time;
				
				count++;
				
				wasteTime = Math.max(wasteTime, time);
				
				for(int dir=0; dir<4; dir++) {
					int ar = r + dr[dir];
					int ac = c + dc[dir];
					
					if(ar < 0 || ar >= N || ac < 0 || ac >= N || visited[ar][ac] || field[ar][ac] == 1) {
						continue;
					}
					
					dq.offer(new Pos(ar, ac, time+1));
					visited[ar][ac] = true;
				}
			}
			if(count == area) {
				result = Math.min(result, wasteTime);
			}
		}
		
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
		
		br.close();
	}

	private static void combination(int idx, int visited, int maxLen, int count) {
		if(count == 0) {
			cases.add(visited);
			return;
		}
		
		for(int i=idx; i<maxLen; i++) {
			combination(i+1, visited | 1 << i, maxLen, count-1);
		}
	}
}
