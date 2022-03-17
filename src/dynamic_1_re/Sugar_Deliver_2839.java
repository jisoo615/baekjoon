package dynamic_1_re;
//https://www.acmicpc.net/problem/2839
//설탕배달
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sugar_Deliver_2839 {
	static int[] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		dp = new int[n+1];
		Arrays.fill(dp, 9999);

		dp[3] = dp[5] = 1;
		int answer = dp(n);
		System.out.println(answer);

	}
// bottom up
	static int dp(int n) {
		for(int i=6; i<dp.length; i++) {
			dp[i] = Math.min(dp[i-3], dp[i-5]) +1;
		}
		return dp[n]>=9999 ? -1: dp[n];
	}

}
