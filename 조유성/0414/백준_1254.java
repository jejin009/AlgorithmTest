package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1254 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int size = s.length();
		for(int i = 0; i < size; i++) {
			if(isFal(s.substring(i))) {
				System.out.println(size + i);
				return;
			}
		}
	}

	public static boolean isFal(String s) {
		int size = s.length();
		for (int i = 0; i < size / 2; i++) {
			if (s.charAt(i) != s.charAt(size - i - 1)) {
				return false;
			}
		}
		return true;
	}

}
