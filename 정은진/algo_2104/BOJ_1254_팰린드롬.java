package algo_2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1254_팰린드롬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String  S = br.readLine();
		int len = 0;
		
		for(int i = 0; i < S.length(); i++) {
			String str = makeString(S,i);
			len = str.length();
			boolean flag = true;
			for(int j = 0; j < len/2; j++) {
				char opposite = str.charAt(len-j-1);
				if(str.charAt(j) != opposite) {
					flag = false;
					break;
				}
			}
			if(flag) break;
		}
		System.out.println(len);
	}
	
	private static String makeString(String S, int i) {
		String temp = S.substring(0,i);
		StringBuilder sb1 = new StringBuilder(S);
		StringBuilder sb2 = new StringBuilder(temp);
		return sb1.append(sb2.reverse()).toString();
	}

}
