import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj2866 {

	static int R, C;
	static char[][] arr;
	static int res = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			arr[i] = s.toCharArray();
		}
		binarySearch(0, R-1);
		System.out.println(res);
	}
	private static void binarySearch(int start, int end) {
		int mid = (start+end)/2;
//		System.out.println(mid);
		if(start >= end) {
			if(check(mid)) res = mid; //x
			else res = mid-1; //o
			return;
		}
		boolean flag = check(mid);
		
		if(flag) { //중복이 없다면
//			System.out.println(mid + " 중복없음");
			binarySearch(mid+1, end);
		} else {  //중복이 있다면
//			System.out.println(mid + " 중복있음");
			binarySearch(start, mid-1);
		}
		
	}
	private static boolean check(int mid) {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < C; i++) {
			String temp = "";
			for (int j = mid; j < R; j++) {
				temp += arr[j][i];
			}
			if(list.contains(temp)) return false; //중복있음
			else list.add(temp);
		}
		
		return true; //중복없음
	}

}
