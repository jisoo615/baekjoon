package divide_conquer;

import java.util.Scanner;

public class p11401 {
	final static long p = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		//분자
		long number = factorial(N);
		//분모
		long demon = factorial(K) * factorial(N-K) %p;
		
		System.out.print(number * pow(demon, p-2) %p );

	}
	
	public static long factorial(long n) {
		long fac = 1L;
		
		while(n > 1) {
			fac = (fac * n) % p;
			n--;
		}
		return fac;
	}
	
	public static long pow(long base, long expo) {
		if(expo == 1) {
			return base % p;
		}
		
		long temp = pow(base, expo / 2);
	
		if(expo % 2 == 1) {
			return (temp * temp % p) * base % p;
		}
		return temp * temp % p;

	}

}
