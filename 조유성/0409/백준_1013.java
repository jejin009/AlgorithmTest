package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class 백준_1013 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pattern = "((100+1+)|(01))+";
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			boolean check = Pattern.matches(pattern, s);
			if(check) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}

	}

}
