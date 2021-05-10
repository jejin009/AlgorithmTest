import java.io.*;
import java.util.*;

public class Bj1501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> dictionary = new HashMap<>();
		for (int i = 0; i < N; i++) {
			char[] dic = br.readLine().toCharArray();
			int len = dic.length;
			if(len != 1) Arrays.sort(dic, 1, len-1);
			
			StringBuilder key = new StringBuilder();
			for (int j = 0; j < len; j++) {
				key.append(dic[j]);
			}
			if(dictionary.containsKey(key.toString())) dictionary.replace(key.toString(), dictionary.get(key.toString())+1);
			else dictionary.put(key.toString(), 1);
			
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = 1;
			while(st.hasMoreTokens()) {
				char[] cur = st.nextToken().toCharArray();
				int len = cur.length;
				if(len != 1)Arrays.sort(cur, 1, len-1);
				
				StringBuilder find = new StringBuilder();
				for (int j = 0; j < len; j++) {
					find.append(cur[j]);
				}
				Integer val = dictionary.get(find.toString());
				if(val == null) {
					cnt = 0;
					break;
				}
				cnt *= val;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

}
