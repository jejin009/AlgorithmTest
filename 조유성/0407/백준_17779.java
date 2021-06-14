package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_17779 {
	static int N;
	static int map[][];
	static int cnt[];
	static int total;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		cnt = new int[5];
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				total += map[r][c];
			}
		}

		for (int d2 = 1; d2 <= N; d2++) {
			for (int d1 = 1; d1 + d2 < N; d1++) {
				for (int x = 1; x + d1 + d2 <= N; x++) {
					for (int y = 1; y <= N; y++) {
						if (1 <= y - d1 && y < y + d2 && y + d2 <= N) {
							cal(x, y, d1, d2);
						}
					}
				}
			}
		}
		
		System.out.println(result);
	}

	public static void cal(int x, int y, int d1, int d2) {
		Arrays.fill(cnt, 0);
		boolean check[][] = new boolean[N + 1][N + 1];
		
		// 경계선 구하기
		for (int i = 0; i <= d1; i++) {
			check[x + i][y - i] = true;
			check[x + d2 + i][y + d2 - i] = true;
		}

		for (int i = 0; i <= d2; i++) {
			check[x + i][y + i] = true;
			check[x + d1 + i][y - d1 + i] = true;
		}

		// 1번선거구
		for (int r = 1; r < x + d1; r++) {
			for (int c = 1; c <= y; c++) {
				if(check[r][c]) {
					break;
				}
				cnt[0] += map[r][c];
			}
		}

		// 2번선거구
		for (int r = 1; r <= x + d2; r++) {
			for (int c = N; c > y; c--) {
				if(check[r][c]) {
					break;
				}
				cnt[1] += map[r][c];
			}
		}

		// 3번선거구
		for (int r = x + d1; r <= N; r++) {
			for (int c = 1; c < y - d1 + d2; c++) {
				if(check[r][c]) {
					break;
				}
				cnt[2] += map[r][c];
			}
		}

		// 4번선거구
		for (int r = x + d2 + 1; r <= N; r++) {
			for (int c = N; c >= y - d1 + d2; c--) {
				if(check[r][c]) {
					break;
				}
				cnt[3] += map[r][c];
			}
		}

		// 5번선거구
		cnt[4] = total - cnt[0] - cnt[1] - cnt[2] - cnt[3];

		int min = Integer.MAX_VALUE;
		int max = 0;

		for (int i = 0; i < 5; i++) {
			min = Math.min(min, cnt[i]);
			max = Math.max(max, cnt[i]);
		}
		result = Math.min(result, max - min);
	}

}
