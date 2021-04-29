package johap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2609_1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		if(A<B) {
			int tmp = A;
			A = B;
			B = tmp;
		}
		
		int gcd = GCD(A, B);
		System.out.println(gcd+"\n"+(A*B)/gcd);

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
