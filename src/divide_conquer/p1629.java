package divide_conquer;

import java.util.Scanner;

public class p1629 {
	public static int A, B, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		System.out.print(pow(A, B));
		
		sc.close();
		
	}
	
	public static long pow(long A, long exponent) {
		
		if(exponent == 1) {
			return A %C;
		}
		
		long temp = pow(A, exponent/2);
		
		if(exponent%2 ==1) {
			return (temp * temp %C) * A%C;
		}
		
		return temp * temp %C;
	}

}
