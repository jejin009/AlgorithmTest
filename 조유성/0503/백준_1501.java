package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

// 첫글자와 끝글자 사이의 중간 글자들로 순열을 구해서 여러 단어를 만든다.
// 해당 단어가 사전에 몇개 있는지 구한다.
// 문장에서 각 단어의 사전에서 나올 수 있는 갯수들의 곱으로 경우의 수를 구한다.
// 사전 해쉬맵에는 <단어, 0> 넣고 위 조합에서 중복이 있을 수 있으니 한번 나온거는 1이고, 다음에 참조했을떄 이미 1인거는 경우의수에 넣지 않는걸로

// 정렬 or 알파벳 갯수세서 검사하기(스터디아이디어)
public class 백준_1501 {
	private static char[] word;
	private static int wordLen;
	private static StringBuilder sb;
	private static Set<String> map;
	private static Set<String> set;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		map = new HashSet<>();
		sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			map.add(br.readLine());
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int result = 1;
			while(st.hasMoreTokens()) {
				word= st.nextToken().toCharArray();
				wordLen = word.length;
				int cnt = 0;
				set = new HashSet<>();
				makePermutation(0, new char[wordLen - 2], new boolean[wordLen - 2]);
				Iterator<String> it = set.iterator();
				while(it.hasNext()) {
					if(map.contains(it.next())) {
						cnt++;
					}
				}
				result = cnt > 0 ? result * cnt : result;
			}
			System.out.println(result);
		}
	}
	
	private static void makePermutation(int toSelect, char[] selected, boolean[] visited) {
		if (toSelect == wordLen - 2) {
			sb.setLength(0);
			sb.append(word[0]);
			for(char w : selected) {
				sb.append(w);
			}
			sb.append(word[wordLen-1]);
			set.add(sb.toString());
			return;
		}
		for (int i = 0; i < wordLen - 2; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[toSelect] = word[i + 1];
				makePermutation(toSelect + 1, selected, visited);
				visited[i] = false;
			}
		}
	}
}
