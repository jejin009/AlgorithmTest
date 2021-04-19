package com.ssafy.day0419;

import java.io.*;
import java.util.*;


// 백준 2866. 문자열 잘라내기.
// 이진 탐색.
public class BJ_2866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		Set<String> set = new HashSet<>();
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] tables = new char[R][C];
		for(int i=0; i<R; i++) {
			tables[i] = br.readLine().toCharArray();
		}

		int start = 0;
		int end = R-1;
		int result = R;
		
		while(start <= end) {
			boolean flag = true;
			int mid = (start+end)/2;
			
			System.out.println(start);
			System.out.println(end);
			System.out.println(mid);
			System.out.println("------");
			
			set.clear();
			for(int j=0; j<C; j++) {
				sb.setLength(0);
				
				for(int i=mid; i<R; i++) {
					sb.append(tables[i][j]);
				}
				
				if(set.contains(sb.toString())) {
					System.out.println("들어옴");
					result = mid;
					flag = false;
					break;
				}else {
					set.add(sb.toString());
				}
			}
			
			if(flag) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		
		System.out.println(result-1);
		br.close();
	}
}
