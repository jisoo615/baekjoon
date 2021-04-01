package recursion;

import java.util.Scanner;

//Àç±Í
public class p10872 {
//ÆÑÅä¸®¾ó
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = factorial(n);
		System.out.print(answer);
		sc.close();
	}
	
	public static int factorial(int x) {
		if(x<=1) return 1;
		return x*factorial(x-1);
	}
	

}
