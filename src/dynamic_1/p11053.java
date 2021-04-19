package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//가장 긴 증가하는 부분 수열
public class p11053 {
	public static int[] A;
	public static Integer[] dp;
	public static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		dp = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int max =0;
		for(int i=0; i<N-1; i++) {
			max  = Math.max(dp[i], dp[i+1]);
		}
		System.out.print(max);
		
	}
	
	public static int LIS(int n) {
		if(dp[n]==null) {
			dp[n] = 1;
			for(int i=N-1; i>=0; i--) {
				if(A[i] < A[n]) {//자기보다 전에 작은게 있으면 +1
					dp[n] = Math.max(dp[n], LIS(i)+1);
				}
			}
		}
		
		return dp[n];
	}

}
