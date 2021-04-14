package algo_2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17779_게리맨더링 {

	static int N;
	static int area[][];
	static boolean visited[][];
	static int di[] = { 1, 1, 1, 1 };
	static int dj[] = { -1, 1, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		area = new int[N][N];
		StringTokenizer st = null;
		int s = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				s += area[i][j];
			}
		}

		int total_min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int d1 = 1; d1 <= N; d1++) {
					for (int d2 = 1; d2 <= N; d2++) {
//						if (d1 + d2 == N + N - 2)
//							continue;
						if (0 <= i + d1 && i + d1 < N && 0 <= j + d2 && j + d2 < N) {
							if (0 <= i && i < i + d1 + d2 && i + d1 + d2 < N && 0 <= j - d1 && j - d1 <= j && j < j + d2
									&& j + d2 < N) {
								int sum[] = new int[5];
								int min = Integer.MAX_VALUE;
								int max = Integer.MIN_VALUE;

								for (int r = 0; r < i + d1 - 1; r++) {
									for (int c = 0; c < j; c++) {
										sum[0] += area[r][c];
									}
								}

								for (int r = 0; r < i + d2; r++) {
									for (int c = j; c < N; c++) {
										sum[1] += area[r][c];
									}
								}

								for (int r = i + d1 - 1; r < N; r++) {
									for (int c = 0; c < i - d1 + d2 - 1; c++) {
										sum[2] += area[r][c];
									}
								}
								for (int r = i + d2; r < N; r++) {
									for (int c = j - d1 + d2 - 1; c < N; c++) {
										sum[3] += area[r][c];
									}
								}

								
								sum[4] = s - sum[0] -sum[1] -sum[2] -sum[3];
//								int cnt = 0;
//								int start = j + 1;
//								int mid = (i+ i + d1 + d2+1) / 2;
//								for (int r = i; r <= i + d1 + d2; r++) {
//									if (r <= mid) {
//										cnt++;
//										start--;
//									} else {
//										cnt--;
//										start++;
//									}
//									for (int c = start; c <= start + cnt; c++) {
//										sum[4] += area[r][c];
//									}
//								}
								System.out.println(Arrays.toString(sum));
								for (int k = 0; k < 5; k++) {
									min = Math.min(min, sum[k]);
									max = Math.max(max, sum[k]);
								}
								total_min = Math.min(total_min, max - min);
							}
						}
					}
				}

			}
		}
		System.out.println(total_min);
	}
}
