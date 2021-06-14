import java.io.*;
import java.util.StringTokenizer;

public class Bj3020 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] arr = new int[2][H+1];
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(i % 2 == 0) { //석순
				arr[0][temp]++;
			} else { //종유석
				arr[1][temp]++;
			}
		}
		for (int i = H-1; i > 1; i--) {
			arr[0][i-1] += arr[0][i];
			arr[1][i-1] += arr[1][i];
		}
		int min = Integer.MAX_VALUE;
		int minCount = 0;
		for (int i = 1; i <= H; i++) {
			int destroy = arr[0][i] + arr[1][H-i+1];
			if(destroy <= min) {
				if(destroy == min) {
					minCount++;
				} else {
					min = destroy;
					minCount = 1;
				}
			}
		}
		System.out.println(min + " " + minCount);
	}

}
