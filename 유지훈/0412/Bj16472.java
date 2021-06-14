import java.io.*;
import java.util.Arrays;

public class Bj16472 {

	static int[] eng;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		eng = new int[26];
		int i = 0, j= 0;
		int len = s.length();
		int res = 0;
		eng[s.charAt(0)-97]++;
		while(true) {
//			System.out.println(i + " " + j);
//			System.out.println(Arrays.toString(eng));
			if(i >= len || j >= len) break;
			if(check() > N) {
				eng[s.charAt(i)-97]--;
				i++;
				if(i >= len || j >= len) break;
			} else {
				j++;
				res = Math.max(res, Math.abs(i-j));
				if(i >= len || j >= len) break;
				eng[s.charAt(j)-97]++;
			}
			res = Math.max(res, Math.abs(i-j));
		}
		System.out.println(res);
	}

	public static int check() {
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if(eng[i] > 0) count++;
		}
		return count;
	}
}
