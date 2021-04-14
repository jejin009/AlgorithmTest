package algo_2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {

	static int N, S;
	static int list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		list = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		int res = 0;
		res = twoPointer();
//		for (int len = 1; len < N; len++) {
//			res = makeSum(len);
//			if (res != 0)
//				break;
//		}
		System.out.println(res);
	}

	private static int twoPointer() {
		int i = 0, j = i;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		// i = left
		// j = right
		for (i = 0; i < N; i++) {
			while (j < N) {
				if (sum < S) {
					sum += list[j];
					j++;
					if (sum >= S)
						min = Math.min(min, j - i);
				} else if (sum >= S) {
					min = Math.min(min, j - i);
					sum -= list[i];
					break;
				}
			}
			if (j==N && sum >= S) {
				min = Math.min(min, j - i);
				sum -= list[i];
			}
		}
		if (min == Integer.MAX_VALUE)
			return 0;
		else
			return min;
	}

	private static int makeSum(int len) {

		for (int i = 0; i < N; i++) {
			if (i + len <= N) {
				int sum = 0;
				for (int j = i; j < i + len; j++) {
					sum += list[j];
				}
				if (sum >= S)
					return len;
			}
		}
		return 0;
	}
}
