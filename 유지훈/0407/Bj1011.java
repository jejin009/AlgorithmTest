import java.io.*;
import java.util.*;

public class Bj1011 {

	static int start, end;
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			double temp = Math.sqrt(end-start);
			int inttemp = (int) Math.sqrt(end-start);
			long longtemp = inttemp * inttemp;
			if(temp - (double) inttemp > 0.5) {
				sb.append(inttemp*2+1).append("\n");
			} else if(longtemp == end-start){
				sb.append(inttemp*2-1).append("\n");
			} else {
				sb.append(inttemp*2).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
