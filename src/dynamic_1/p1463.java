package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//숫자 1만들기
public class p1463 {
	public static Integer[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N+1];
		dp[0] = dp[1] = 0;
		System.out.print(recur(N));
	}
	
	public static int recur(int n) {
		if(dp[n]==null) {
			if(n%6==0) {
				dp[n]=Math.min(recur(n-1), Math.min(recur(n/3), recur(n/2))) + 1;
			}
			else if(n%3==0) {
				dp[n]= Math.min(recur(n-1), recur(n/3)) + 1;
			}
			else if(n%2==0) {
				dp[n]= Math.min(recur(n-1), recur(n/2)) +1;
			}
			else {
				dp[n] = recur(n-1)+1;
			}
		}
		return dp[n];
	}

}
