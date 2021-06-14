package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1806 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		boolean check = false;
		
		while(start < N) {
			if(sum >= S || end >= N) {
				if(sum >= S) {
					min = Math.min(min, end - start);
					check = true;
				}
				start++;
				sum -= arr[start - 1];
			}else if(sum < S) {
				end++;
				sum += arr[end - 1];
			}
		}
		
		if(check) {
			System.out.println(min);
		}else {
			System.out.println(0);
		}
		
	}
}
