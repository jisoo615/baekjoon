package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1003 {
	public static Integer[][] dp = new Integer[41][2];//N은 40까지 입력받음;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		dp[0][0]=1;//n이 0일때 fibo(0)호출횟수=1
		dp[0][1]=0;//n이 0일때 fibo(1)호출횟수=0
		dp[1][0]=0;//n이 1일때 fibo(0)호출횟수=0
		dp[1][1]=1;//n이 1일때 fibo(1)호출횟수=1
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			fibonacci(x);
			sb.append(dp[x][0]+" "+dp[x][1]+"\n");
		}
		System.out.print(sb);
	}

	public static Integer[] fibonacci(int n) {
		if(dp[n][0]==null || dp[n][1]==null) {
			dp[n][0] = fibonacci(n-1)[0]+fibonacci(n-2)[0];
			dp[n][1] = fibonacci(n-1)[1]+fibonacci(n-2)[1];
		}
		
		return dp[n];
	}
	
}
