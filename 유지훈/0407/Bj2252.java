import java.io.*;
import java.util.*;

public class Bj2252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //과목 수
		int M = Integer.parseInt(st.nextToken()); //선수조건
		int[] depth = new int[N+1];
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A].add(B);
			depth[B]++;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if(depth[i]==0) q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int temp = q.poll();
				sb.append(temp + " ");
				
				for (Integer integer : arr[temp]) {
					depth[integer]--;
					if(depth[integer] == 0) q.offer(integer);
				}
			}
		}
		System.out.println(sb.toString());
	}

}
