import java.io.*;

public class Bj1254 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int res = s.length();
		int cnt = -1;
		
		while(true) {
			String temp = s;
			for (int i = cnt; i >= 0; i--) {
				temp += s.charAt(i);
			}
			System.out.println(temp);
			if(isPalindrome(temp)) {
				res = temp.length();
				break;
			} else cnt++;
		}
		System.out.println(res);
	}

	public static boolean isPalindrome(String s) {
		int len = s.length();
		for (int i = 0; i < len/2; i++) {
			if(s.charAt(i) != s.charAt(len-i-1)) return false;
		}
		return true;
	}
}
