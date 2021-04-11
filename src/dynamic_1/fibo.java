package dynamic_1;

import java.util.Scanner;
//동적계획법으로 푼 피보나치
public class fibo {
	public static long[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		arr = new long[N+1];
		for(int i=0; i<N+1; i++) {
			arr[i]=-1;
		}arr[0]=0; arr[1]=1;

		fibonacci(N);
		for(long x: arr) {
			System.out.print(x+" ");
		}
	}
	
	public static long fibonacci(int n) {
		if(arr[n]==-1) {
			arr[n] = fibonacci(n-1)+fibonacci(n-2);
		}
		return arr[n];
	}

}
