import java.io.*;
import java.util.StringTokenizer;

public class Bj17779 {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N+1];
		int all = 0;
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				all += arr[i][j];
			}
		}
		int res = Integer.MAX_VALUE;
		for (int x = 2; x < N; x++) {
			for (int y = 2; y < N; y++) {
				for (int d1 = 1; d1 <= N; d1++) {
					for (int d2 = 1; d2 <= N; d2++) {
						if(check(x,y,d1,d2)) continue;
						boolean[][] line = new boolean[N+1][N+1];
						for (int r = x,c=y; r <= x+d1 && c >= y-d1; r++, c--) line[r][c] = true;
						for (int r = x,c = y; r <= x+d2 && c <= y+d2; r++,c++) line[r][c] = true;
						for (int r = x+d1,c = y-d1; r <= x+d1+d2 && c <= y-d1+d2; r++,c++) line[r][c] = true;
						for (int r = x+d2,c = y+d2; r <= x+d1+d2 && c >= y+d2-d1; r++,c--) line[r][c] = true;
						int one = 0, two = 0, three = 0, four = 0;
						int max = Integer.MIN_VALUE;
						int min = Integer.MAX_VALUE;
						//1선거구
						for (int r = 1; r < x+d1; r++) {
							for (int c = 1; c <= y; c++) {
								if(line[r][c]) break;
								one += arr[r][c];
							}
						}
						max = Math.max(max, one);
						min = Math.min(min, one);
						//2선거구
						for (int r = 1; r <= x+d2; r++) {
							for (int c = N; c > y; c--) {
								if(line[r][c]) break;
								two += arr[r][c];
							}
						}
						max = Math.max(max, two);
						min = Math.min(min, two);
						//3선거구
						for (int r = x+d1; r <= N; r++) {
							for (int c = 1; c < y-d1+d2; c++) {
								if(line[r][c]) break;
								three += arr[r][c];
							}
						}
						max = Math.max(max, three);
						min = Math.min(min, three);
						//4선거구
						for (int r = x+d2+1; r <= N; r++) {
							for (int c = N; c >= y-d1+d2; c--) {
								if(line[r][c]) break;
								four += arr[r][c];
							}
						}
						max = Math.max(max, four);
						min = Math.min(min, four);
						//5선거구
						int five = all - one - two - three - four;
						max = Math.max(max, five);
						min = Math.min(min, five);
						
						res = Math.min(res, max-min);
//						if(x==2 && y==3 && d1==1 && d2==2) {
//							for (int i = 1; i <= N; i++) {
//								for (int j = 1; j <= N; j++) {
//									if(line[i][j]) System.out.print(5 + " ");
//									else System.out.print(0 + " ");
//								}
//								System.out.println();
//							}
//						}
//						System.out.print(one + " " + two + " " + three + " " + four + " " + five);
//						System.out.println("######## "+x + " " + y + " " + d1 + " " + d2 + " " + res);
					}
				}
			}
		}
		
		System.out.println(res);
	}

	private static boolean check(int x, int y, int d1, int d2) {
		if(x+d1+d2 > N) return true;
		if(y-d1 < 1) return true;
		if(y+d2 > N) return true;
		return false;
	}

}
