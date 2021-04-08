import java.io.*;
import java.util.regex.Pattern;

public class Bj1013 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String s = br.readLine();
			boolean f = Pattern.matches("(100+1+|01)+", s);
			sb.append(f ? "YES" : "NO").append("\n");
		}
		System.out.println(sb.toString());
	}

}
