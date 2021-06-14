import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj11725 {

	static int[] res;
	static Node[] tree;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		tree = new Node[N+1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new Node(i);
		}
		res = new int[N+1];
		visit = new boolean[N+1];
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			tree[from].list.add(to);
			tree[to].list.add(from);
		}
		dfs(1, 1);
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(res[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static class Node{
		int num;
		ArrayList<Integer> list = new ArrayList<>();
		protected Node(int num) {
			super();
			this.num = num;
		}
		
	}
	
	public static void dfs(int cur, int parent) {
		if(tree[cur].list.size() == 0) return;
		if(visit[cur]) {
			return;
		}
		res[cur] = parent;
		tree[cur].list.remove((Object)parent);
		visit[cur] = true;
		for (int i = 0; i < tree[cur].list.size(); i++) {
			dfs(tree[cur].list.get(i), cur);
		}
	}
}
