import java.io.*;
import java.util.StringTokenizer;

public class Bj5710 {

	static int A, B, Wh;
	static long res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			if(A == 0 && B == 0) break;
			Wh = use(A);
			res = 0;
			binarySearch(0, Wh);
			sb.append(res).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static void binarySearch(int start, int end) {
		int mid = (start+end) / 2;
		if(start >= end) {
			res = cost(mid);
			return;
		}
		long sanggun = cost(mid);
		long nabor = cost(Wh-mid);
		long b = Math.abs(sanggun - nabor);
		if(b > B) {
			binarySearch(mid+1, end);
		} else if(b < B) {
			binarySearch(start, mid);
		} else {
			res = sanggun;
			return;
		}
	}

	static int use (int cost)
	{
	    if (cost > 4979900)
	        return (cost + 2020100)/7;
	    else if (cost > 29900)
	        return (cost + 20100)/5;
	    else if (cost > 200)
	        return (cost + 100)/3;
	    else
	        return cost/2;
	}
	
	static long cost(int use) {
		if (use > 1000000)
			return use*7 - 2020100;
		else if (use > 10000)
			return use*5 - 20100;
		else if (use > 100)
			return use*3 - 100;
		else
			return use*2;
	}
}
