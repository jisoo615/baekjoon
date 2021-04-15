package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2579 {
	public static int[] stairs;
	public static int[] dp;
	public static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		stairs = new int[N];
		dp = new int[N];
		for(int i=0; i<N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = stairs[0];
		dp[1] = stairs[1];
		if(N>=2) {
			dp[2] = stairs[1]+stairs[2];
		}
		System.out.print(find(N-1));

	}
	
	public static int find(int n) {
		if(dp[n]==0) {
			return dp[n]=Math.max(find(n-2), find(n-3)+stairs[n-1])+stairs[n];
		}
		return dp[n];
	}

}
