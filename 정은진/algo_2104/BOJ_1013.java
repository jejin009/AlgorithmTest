package algo_2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1013 {

	static String str;
	static String str1 = "100";
	static String str2 = "1";
	static String str3 = "01";
	static boolean flag = false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int  T = Integer.parseInt(br.readLine());
		
		for(int testcase= 0; testcase <T ; testcase++) {
			String str = br.readLine();
			flag = false;
			divide(0,1);
		}
	}
	private static void divide(int before, int cnt) {
		if(flag) return;
		if(cnt==str.length()) {
			flag = true;
			return;
		}
		
		boolean suc = false;
		String str1 = "100";
		String str2 = "1";
		String str3 = "01";
		String temp = str.substring(before, cnt-1);
		for(int i = 0; i < cnt-before; i++) {
			
				
		}
	}
}
