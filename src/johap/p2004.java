package johap;

import java.util.Scanner;

public class p2004 {
//(n m) = n! / m!*(n-m)!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		//각각 팩토리얼들의 2와 5의 승수를 구한다.
		int five = five_power_n(N) - five_power_n(M) - five_power_n(N-M);
		int two = two_power_n(N) - two_power_n(M) - two_power_n(N-M);
		
		System.out.print(five < two ? five : two);
		
		sc.close();

	}
	
	static int five_power_n(int n) {
		int cnt =0; 
		while(n>=5) {
			cnt += n/5;
			n = n/5;
		}
		return cnt;
	}
	
	static int two_power_n(int n) {
		int cnt =0; 
		while(n>=2) {
			cnt += n/2;
			n = n/2;
		}
		return cnt;
	}
}
