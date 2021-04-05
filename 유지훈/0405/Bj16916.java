import java.io.*;

public class Bj16916 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] S = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		int plen = P.length;
		int slen = S.length;
		int[] fail = new int[plen];
		for (int i = 1,j = 0; i < plen; i++) {
			while(j > 0 && P[i] != P[j]) j = fail[j-1];
			if(P[i] == P[j]) fail[i] = ++j;
		}
		
		for (int i = 0,j = 0; i < slen; i++) {
			while(j > 0 && S[i] != P[j]) j = fail[j-1];
			if(S[i] == P[j]) {
				if(j == plen-1) {
					System.out.println(1);
					return;
				} else j++;
			}
		}
		
		System.out.println(0);
	}

}
