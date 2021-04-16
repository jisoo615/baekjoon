package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2579 {
	public static int[] stairs;
	public static Integer[] dp;
	public static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		stairs = new int[N+1];
		dp = new Integer[N+1];
		for(int i=1; i<=N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = stairs[0];//dp[0] null 대신 0으로 초기화
		dp[1] = stairs[1];
		if(N>=2) {
			dp[2] = stairs[1]+stairs[2];
		}
		System.out.print(find(N));

	}
	
	public static int find(int n) {
		if(dp[n]==null) {//integer라서 0 아니라 null일때
			return dp[n]=Math.max(find(n-2), find(n-3)+stairs[n-1])+stairs[n];
		}
		return dp[n];
	}

}
