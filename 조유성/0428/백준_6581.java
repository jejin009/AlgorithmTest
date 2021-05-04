package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_6581 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s;
		int cnt = 0;
		while((s=br.readLine()) != null) {
			String words[] = s.split(" |	");
			for(String word : words) {
				if(word.equals("<br>")) {
					sb.append("\n");
				}else if(word.equals("<hr>")) {
					if(cnt != 0) {
						sb.append("\n");
					}
					for(int i = 0; i < 80; i++) {
						sb.append("-");
					}
					sb.append("\n");
					cnt = 0;
				}else if(word.equals("")){
					continue;
				}else {
					if(cnt + word.length() <= 80) {
						cnt += word.length();
					}else {
						cnt = word.length();
						sb.append("\n");
					}
					sb.append(word);
					if(cnt < 80) {
						sb.append(" ");
						cnt++;
					}
				}
			}
		}
		System.out.println(sb.toString());
	}

}