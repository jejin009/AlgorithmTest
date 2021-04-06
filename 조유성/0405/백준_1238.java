package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1238 {
	static int N;
	static int M;
	static int X;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()) - 1;

		int adjmat[][] = new int[N][N];
		int distance[] = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		int revmat[][] = new int[N][N];
		int revdis[] = new int[N];
		Arrays.fill(revdis, Integer.MAX_VALUE);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			adjmat[u][v] = weight;
			revmat[v][u] = weight;
		}
		
		dijkstra(adjmat, distance, X);
		dijkstra(revmat, revdis, X);
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, distance[i] + revdis[i]);
		}
		
		System.out.println(max);

	}

	public static void dijkstra(int adjmat[][], int distance[], int start) {
		boolean visited[] = new boolean[N];
		distance[start] = 0;

		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int current = 0; // min 최소비용에 해당하는 정점 번호
			// step1. : 처리하지 않은 정점중에 출발지에서 가장 가까운(최소비용) 정점 선택
			for (int j = 0; j < N; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;
			
			// step2. 선택된 current를 경유지로 하여 아직 처리하지 않은 다른 정점으로의 최소비용을 따져본다.
			for (int j = 0; j < N; j++) {
				if(!visited[j] && adjmat[current][j] != 0 && distance[j] > distance[current] + adjmat[current][j]) {
					distance[j] = distance[current] + adjmat[current][j];
				}
			}
		}
	}

}
