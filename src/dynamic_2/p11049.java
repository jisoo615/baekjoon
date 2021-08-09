package dynamic_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11049 {
	static int[][] dp;
	static int[][] a;
	
	public static int solve(int start, int end) {
		if(start==end) return 0;
		if(dp[start][end] != Integer.MAX_VALUE) {//한번 갱신이 됐던 거면 바로 반환
			return dp[start][end];
		}
		for(int i=start; i<end; i++) {
			int cost = solve(start, i) + solve(i+1, end) + a[start][0]*a[i][1]*a[end][1];
			dp[start][end] = Math.min(dp[start][end], cost);
		}
		return dp[start][end];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		a = new int[N][2];
		dp = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], Integer.MAX_VALUE);//dp를 다 maxvalue로 초기화해줌
		}
		
		System.out.print(solve(0, N-1));
	}

}
