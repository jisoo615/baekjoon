package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11053_bottomUp {
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
		
		//dp
		for(int i=0; i<N; i++) {
			dp[i]=1;
			for(int j=0; j<i; j++) {
				if(A[j] < A[i] && dp[i] < dp[j]+1 ) {
					dp[i] = dp[j]+1;
				}
			}
		}
		
		int max =0;
		for(int i=0; i<N; i++) {
			max  = Math.max(max, dp[i]);
		}
		System.out.print(max);
		
	}

}
