import java.util.*;

public class Pm보석쇼핑 {

	public static void main(String[] args) {
//		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		String[] gems = {"AA", "AB", "AC", "AA", "AC"};
		int len = gems.length;
		Map<String, Integer> map = new HashMap<String, Integer>(); //<보석, 개수>
		for (int i = 0; i < len; i++) {
			String s = gems[i];
//			if(map.containsKey(s)) map.replace(s, map.get(s) + 1);
//			else map.put(s, 1);
			if(!map.containsKey(s)) map.put(s, 0);
		}
		int kind = map.size();
		int cnt = 0;
		int end = 0;
		for (int i = 0; i < len; i++) {
			String s = gems[i];
			if(map.get(s) == 0) cnt++;
			map.replace(s, map.get(s) + 1);
			if(cnt == kind) {
				end = i;
				break;
			}
		}
		System.out.println(end);
		int start = 0;
		int[] answer = new int[2];
		answer[0] = start+1;
		answer[1] = end+1;
		boolean full = true;
		int min = end - start;
		while(true) {
			if(full) {
				if(end - start < min) {
					answer[0] = start+1;
					answer[1] = end+1;
					min = end - start;
				}
				map.replace(gems[start], map.get(gems[start]) - 1);
				if(map.get(gems[start]) == 0) full = !full;
				start++;
			} else {
				end++;
				if(end == len || start > end) break;
				if(map.get(gems[end]) == 0) full = !full;
				map.replace(gems[end], map.get(gems[end]) + 1);
			}
			if(end == len || start > end) break;
		}
		
		
		
		
//		int left = 0;
//		int right = len-1;
//		while(true) {
//			if(map.get(gems[right]) > 1) {
//				map.replace(gems[right], map.get(gems[right]) - 1);
//				right--;
//			} else if(map.get(gems[left]) > 1) {
//				map.replace(gems[left], map.get(gems[left]) - 1);
//				left++;
//			} else if(map.get(gems[right]) == 1 && map.get(gems[left]) == 1) {
//				answer[0] = left+1;
//				answer[1] = right+1;
//				break;
//			}
//		}
		System.out.println(Arrays.toString(answer));
	}

}
