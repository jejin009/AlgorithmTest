import java.io.*;
import java.util.StringTokenizer;

public class Bj1405 {

	static int N;
	static int[] arr = new int[4]; //e w s n
	static double res = 0;
	static boolean[][] visit = new boolean[30][30];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		backtracking(0, 15, 15, 1);
		System.out.println(res);
	}

	public static void backtracking(int cnt, int r, int c, double percent) {
		if(visit[r][c]) return;
		if(cnt == N) {
			res += percent;
			return;
		}
		visit[r][c] = true;
		
		backtracking(cnt+1, r, c+1, percent * arr[0]/100);
		backtracking(cnt+1, r, c-1, percent * arr[1]/100);
		backtracking(cnt+1, r+1, c, percent * arr[2]/100);
		backtracking(cnt+1, r-1, c, percent * arr[3]/100);
		
		visit[r][c] = false;
	}

}
