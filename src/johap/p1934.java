package johap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1934 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(A<B) {
				int tmp = A;
				A = B;
				B = tmp;
			}
			
			int gcd = GCD(A, B);
			sb.append((A*B)/gcd+"\n");

		}
		
		System.out.print(sb);
	}
	
		
		public static int GCD(int a, int b) {
			while(b!=0) {
				int r = a%b;
				a = b;
				b = r;
			}
			return a;
		}

}