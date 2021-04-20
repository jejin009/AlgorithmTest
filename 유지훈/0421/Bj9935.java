import java.io.*;
import java.util.Stack;

public class Bj9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String explosion = br.readLine();
		int slen = s.length();
		int elen = explosion.length();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < slen; i++) {
			stack.push(s.charAt(i));
			if(stack.size() >= elen) {
				StringBuilder temp = new StringBuilder();
				boolean flag = false;
				for (int j = elen-1; j >= 0; j--) {
					if(stack.peek() != explosion.charAt(j)) {
						flag = true;
						break;
					}
					else {
						temp.append(stack.pop());
					}
				}
				if(flag) {
					for (int j = temp.length()-1; j >= 0 ; j--) {
						stack.push(temp.charAt(j));
					}
				}
			}
		}
		
		if(stack.isEmpty()) System.out.println("FRULA");
		else {
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			System.out.println(sb.reverse());
		}
	}

}
