import java.io.*;
import java.util.*;

import javax.xml.crypto.Data;

public class Bj14567 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //과목 수
		int M = Integer.parseInt(st.nextToken()); //선수조건
		int[] res = new int[N+1];
		Arrays.fill(res, 1);
		PriorityQueue<data> pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		while(!pq.isEmpty()) {
			int a = pq.peek().a;
			int b = pq.peek().b;
			pq.poll();
			if(res[a]-res[b] >= 0) {
				res[b] += res[a]-res[b]+1;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(res[i] + " ");
		}
		System.out.println(sb.toString());
	}

	static class data implements Comparable<data>{
		int a, b;

		protected data(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(data o) {
			
			return this.a-o.a == 0 ? this.b-o.b: this.a-o.a;
		}
		
	}
}
