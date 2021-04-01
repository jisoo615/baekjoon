package recursion;

import java.util.Scanner;

public class p10870_fibo {
//피보나치
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = fibonacci(n);
		System.out.print(answer);
sc.close();
	}
	
	public static int fibonacci(int x) {
		if(x==0) return 0;
		else if(x==1) return 1;
		else return fibonacci(x-2)+fibonacci(x-1);
	}

}
