package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램
//dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
public class p9095 {
	static int[] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-- >0) {
			int n = Integer.parseInt(br.readLine());
			dp = new int[n+1];

			sb.append(dp(n)).append("\n");
		}

		System.out.print(sb);
	}

	static public int dp(int n) {

		if(n==1) return dp[1] = 1;
		if(n==2) return dp[2] = 2;
		if(n==3) return dp[3] = 4;

		//if(n>=3)
		dp[n] = dp(n-1) + dp(n-2) + dp(n-3);

		return dp[n];
	}

}
