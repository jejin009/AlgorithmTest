import java.io.*;
import java.util.*;


// BJ 3865. 학회원.
// 해시맵, 위상 정렬.
public class BJ_3865 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int num = Integer.parseInt(br.readLine());
			String base = " ";
			
			if(num == 0) {
				break;
			}
			
			Map<String, Set<String>> groups = new HashMap<String, Set<String>>();
			Map<String, Integer> stoi = new HashMap<String, Integer>();
			List<String>[] adjList = new ArrayList[num];
			int[] ingredient = new int[num];
			String[] itos = new String[num];
			
			for(int i=0; i<num; i++) {
				adjList[i] = new ArrayList<String>();
				st = new StringTokenizer(br.readLine(), ":,.");
				
				String key = st.nextToken();
				if(base.equals(" ")) {
					base = key;
				}
				stoi.put(key, i);
				itos[i] = key;
				
				Set<String> values = new HashSet<>();
				while(st.hasMoreTokens()) {
					values.add(st.nextToken());
				}
				
				groups.put(key, values);
			}
			
			for(Map.Entry<String, Set<String>> entrySet : groups.entrySet()) {
				String key = entrySet.getKey();
				if(key.equals(base)) {
					continue;
				}
				
				for(Map.Entry<String, Set<String>> entrySet2 : groups.entrySet()) {
					String target = entrySet2.getKey();
					Set<String> values = entrySet2.getValue();
					
					if(values.contains(key)) {
						ingredient[stoi.get(target)]++;
						groups.get(target).remove(key);
						adjList[stoi.get(key)].add(target);
					}
 				}
			}
			
			System.out.println("-------------");
			System.out.println(Arrays.toString(ingredient));
			System.out.println(groups.get(base).toString());
			
			Deque<Integer> dq = new LinkedList<Integer>();
			for(int i=0; i<num; i++) {
				if(ingredient[i] == 0) {
					dq.offer(i);
				}
			}
			
			while(!dq.isEmpty()) {
				int current = dq.poll();
				
				System.out.println(current + " " + itos[current]+ " "  + groups.get(itos[current]).toString());
				if(current == 0) {
					break;
				}
				
				for(String next : adjList[current]) {
					int intNext = stoi.get(next);
					System.out.println("intNext : " + intNext);
					ingredient[intNext]--;
					
					groups.get(next).addAll(groups.get(itos[current]));
					
					if(ingredient[intNext] == 0) {
						dq.offer(intNext);
					}
				}
			}
			
			sb.append(groups.get(base).size()).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
