package algo_2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17779_게리맨더링 {

	static int N;
	static int area[][];
	static int di[]= {1,1,1,1};
	static int dj[]= {-1,1,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		area = new int[N][N];
		StringTokenizer st = null;
		for(int i = 0;i  <N; i++) {
			 st = new StringTokenizer(br.readLine());
			for(int j = 0; j <N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
