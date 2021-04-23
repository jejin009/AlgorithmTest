import java.io.*;
import java.util.*;

// 백준 1967. 트리의 지름.
// DFS.
public class BJ_1967 {
	
	public static class Node{
		int num;
		int weight;
		
		public Node(int num, int weight) {
			super();
			this.num = num;
			this.weight = weight;
		}
	}
	
	static Node result = new Node(0, Integer.MIN_VALUE);
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		
		List<Node>[] adjList = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Node(to, weight));
			adjList[to].add(new Node(from, weight));
		}
		
		dfs(adjList, new boolean[N+1], 1, 0);
		result.weight = 0;
		dfs(adjList, new boolean[N+1], result.num, 0);
		
		System.out.println(result.weight);
		br.close();
	}

	private static void dfs(List<Node>[] adjList, boolean[] visited, int idx, int weight) {
		visited[idx] = true;
		
		if(result.weight < weight) {
			result.weight = weight;
			result.num = idx;
		}
		
		for(Node next : adjList[idx]) {
			if(!visited[next.num]) {
				dfs(adjList, visited, next.num, weight+next.weight);
			}
		}
	}
}
