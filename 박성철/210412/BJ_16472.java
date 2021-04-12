package com.ssafy.day0412;

import java.io.*;

// 백준 16472. 고냥이.
// 투 포인터.
public class BJ_16472 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[] input = br.readLine().toCharArray();
		int[] visited = new int[26];
		
		int result = 0;
		int l = 0;
		int r = 0;
		int cnt = 1;
		visited[input[0] - 'a']++;
		
		while(true) {
			if(cnt <= N) {
				result = Math.max(result, r-l+1);
				
				r++;
				if(r == input.length) {
					break;
				}
				
				visited[input[r] - 'a']++;
				if(visited[input[r] - 'a'] == 1) {
					cnt++;
				}
			}else {
				
				visited[input[l] - 'a']--;
				if(visited[input[l] - 'a'] == 0){
					cnt--;
				}
				l++;
			}
		}
		
		System.out.println(result);
		br.close();
	}
}



// 완전 탐색 방식.
//public class Main {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int N = Integer.parseInt(br.readLine());
//		
//		char[] input = br.readLine().toCharArray();
//		
//		int result = 0;
//		for(int i=0; i<input.length; i++) {
//			char[] arr = new char[N];
//			int idx = 0;
//			int sum = 1;
//			arr[idx++] = input[i];
//			
//			for(int j=i+1; j<input.length; j++) {
//				if(check(arr, input[j])) {
//					sum++;
//					continue;
//				}
//				
//				if(idx < N) {
//					arr[idx++] = input[j];
//					sum++;
//					continue;
//				}
//				
//				break;
//			}
//			result = Math.max(result, sum);
//		}
//		
//		System.out.println(result);
//		br.close();
//	}
//
//	private static boolean check(char[] arr, char c) {
//		for(int i=0; i<arr.length; i++) {
//			if(arr[i] == c) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//}



