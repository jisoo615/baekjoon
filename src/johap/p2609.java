package johap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//유클리드 호제법
public class p2609 {
//최대공약수 최소공배수 구하기
	//재귀
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
		
		//최대공약수(GCD) Greatest Common Divisor 구하기 유클리드 호제법
		int gcd = GCD(A, B);
		System.out.println(gcd);
		System.out.print(A*B / gcd); //최소공배수 = A*B/최대공약수
		
	}
	
	public static int GCD(int a, int b) {
		if(b==0) {
			return a;
		}
		return GCD(b, a%b);
	}

}
