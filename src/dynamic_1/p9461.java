package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//dp배열 int->long 타입으로 바꿨더니 정답
public class p9461 {
//1 1 1 2 2 3 4 5 7 9 12 16 21
	public static long[] dp = new long[101];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=6; i<101; i++) {
			dp[i]=-1;
		}
		dp[1]=1;dp[2]=1;dp[3]=1;dp[4]=2;dp[5]=2;dp[6]=3;
		
		for(int i=0; i<x; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(P(N)+"\n");
		}
		System.out.print(sb);
	}
	
	public static long P(int N) {
		if(dp[N]==-1) {
			return dp[N]=P(N-1)+P(N-5);
			//근데 dp[N] = P(N-2)+P(N-3) 도 있음..
		}
		return dp[N];
	}

}
