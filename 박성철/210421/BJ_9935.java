import java.io.*;
import java.util.*;


// 백준 9935. 문자열 폭발.
// char 배열. (stack식).
public class BJ_9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		
		char bombTrigger = bomb[bomb.length-1];
		
		char[] stack = new char[1000001];
		int idx = 0;
		for(int i=0; i<str.length; i++) {
			stack[idx] = str[i];
			
			if(str[i] == bombTrigger && idx-bomb.length+1 >= 0) {
				int bombIdx = 0;
				for(int j=idx-bomb.length+1; j<=idx; j++) {
					if(bomb[bombIdx++] != stack[j]) {
						break;
					}
					if(j == idx) {
						idx -= bomb.length;
					}
				}
			}
			idx++;
		}
		String result = String.valueOf(stack, 0, idx);
		if(result.length() == 0) {
			System.out.println("FRULA");
		}else {
			System.out.println(result);
		}
	}
}
