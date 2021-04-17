package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10844_1 {
//반복문 bottom-up 방식 (1부터 시작)
	final static long mod = 1000000000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N+1][10];
		
		// 첫 번째 자릿수는 오른쪽 맨 끝의 자릿수이므로 경우의 수가 1개밖에 없음 
		for(int i=1; i<10; i++) {// 멘 첫자리(왼쪽자리)는 0이 될수 없기에 1부터 시작
			dp[1][i] = 1;
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=0; j<10; j++) {
				if(j==0) {
					dp[i][0]=dp[i-1][1] % mod;
				}
				else if(j==9) {
					dp[i][9]=dp[i-1][8] % mod;
				}
				else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
				}
			}
		}
		long result =0;//int타입으로 했더니 틀렸었음..
		for(int i=0; i<10; i++) {
			result += dp[N][i];
		}
		System.out.print(result % mod);
	}

}
