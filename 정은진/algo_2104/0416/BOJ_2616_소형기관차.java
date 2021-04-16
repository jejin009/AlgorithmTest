package algo_2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2616_소형기관차 {

	static int train[];
	static int maxPeople[];
	static int mini;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		train = new int[N];
		maxPeople = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			train[i] = Integer.parseInt(st.nextToken());
		}
		mini = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < mini; i++) {
			maxPeople[0] += train[i];
		}
		
		int start = 0, end = mini;
		while(end < N) {
			maxPeople[start+1] = maxPeople[start] -train[start] + train[end];
			start++;
			end++;
		}
		
		
		int max = 0;
		for(int i = 0; i < N-(2*mini); i++) {
			for(int j = i+mini; j < N-mini; j++) {
				for(int c = j + mini; c < N; c++) {
					int sum = maxPeople[i] + maxPeople[j] + maxPeople[c];
					max = Math.max(max, sum);
				}
			}
		}
		System.out.println(max);
	}
}

