import java.io.*;
import java.util.StringTokenizer;

public class Bj15685 {

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[101][101];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			//0세대
			arr[x][y] = true;
			x += dx[d]; y += dy[d];
			arr[x][y] = true;
			
			int[] directs = new int[(int) Math.pow(2, g)];
			directs[0] = d;
			int index = 1;
			while(true) {
				if(index >= directs.length) break;
				
				int generation = index-1;
				while(true) {
					if(generation < 0) break;
					int tempD = directs[generation--] + 1;
					if(tempD == 4) tempD = 0;
					
					directs[index++] = tempD;
					x += dx[tempD]; y += dy[tempD];
					arr[x][y] = true;
				}
			}
		}
		
		int res = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(arr[i][j] && arr[i+1][j] && arr[i][j+1] && arr[i+1][j+1]) res++;
			}
		}
		System.out.println(res);
	}

}
