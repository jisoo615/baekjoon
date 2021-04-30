package johap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3036 {

	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int big = arr[0];
		for(int i=1; i<N; i++) {
			int gcd = GCD(big, arr[i]);
			sb.append(big/gcd+"/"+arr[i]/gcd+"\n");
		}
		
		System.out.print(sb);

	}
	
	static int GCD(int a, int b) {
		while(b==0) {
			return a;
		}
		return GCD(b, a%b);
	}

}
