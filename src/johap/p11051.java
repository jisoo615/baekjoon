package johap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//이항계수 
//+동적계획법 추가
public class p11051 {
	static int[][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][R+1];
		
		System.out.print(BC(N, R)%10007);

	}

	static int BC(int N, int K){//Binomial coefficient 이항계수
		if (dp[N][K] > 0) {//이미 구했던 거면 바로 리턴
			return dp[N][K];
		}
		
		if(N==K || K ==0) {
			return dp[N][K]=1;
		}
		
		return dp[N][K] = BC(N-1, K-1) + BC(N-1, K);
	}
}
