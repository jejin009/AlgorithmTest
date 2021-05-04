package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_9935 {
	// 메모리초과
//	public static void main(String[] args) throws IOException{
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		String s = br.readLine();
//		String bomb = br.readLine();
//		
//		while(s.contains(bomb)) {
//			String[] temp = s.split(bomb);
//			for(String t : temp) {
//				sb.append(t);
//			}
//			s = sb.toString();
//			sb.setLength(0);
//		}
//		if(s.isEmpty()) {
//			System.out.println("FRULA");
//		}else {
//			System.out.println(s);
//		}
//	}
//	
	// 스택으로 풀어보자
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String origin = br.readLine();
		String remove = br.readLine();
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < origin.length(); i++) {
			stack.push(origin.charAt(i));

			if (stack.size() >= remove.length()) {
				boolean flag = true;
				for (int j = 0; j < remove.length(); j++) {
					if (stack.get(stack.size() - remove.length() + j) != remove.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					for (int j = 0; j < remove.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char ch : stack) {
			sb.append(ch);
		}

		System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
	}

}
