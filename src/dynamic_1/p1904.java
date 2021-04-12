package dynamic_1;

import java.util.Scanner;

/*
 N=1 1 1개
 N=2 11 00 2개
 N=3 111 100 001 3개
 N=4 1111 1100 1001 0011 0000 5개
 N=5 11111 11100 11001 10011 00111 00001 00100 10000 8개
 N=6 111111 111100 111001 110011 100111 001111 110000 100001 100100 001100 001001 000011 000000 13개
 ... it's like fibonacci..*
 */
public class p1904 {
	public static int[] dp=new int[1000001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		dp[1]=1;
		dp[2]=2;
		for(int i=3; i<1000001; i++) {
			dp[i]=-1;
		}
			
		tile(N);
		System.out.print(dp[N]);
		sc.close();
	}
	
	public static int tile(int N){
		if(dp[N]==-1) {
			return dp[N] = (dp[N]=tile(N-1)+tile(N-2)) %15746;
		}
		return dp[N];
	}

}
