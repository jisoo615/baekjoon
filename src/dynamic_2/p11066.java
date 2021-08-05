package dynamic_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11066 {
	static int dp[][];
	static int sum[];
	static int fiction[];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<N; t++) {
			int K = Integer.parseInt(br.readLine());//k=3~500 Ã©ÅÍ ¼ö
			
			fiction = new int[K+1];
			sum = new int[K+1];
			dp = new int[502][502];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=1; j<=K; j++) {
				fiction[j] = Integer.parseInt(st.nextToken());
				sum[j] +=  sum[j-1] + fiction[j];
			}
			
			for(int i=2; i<=K; i++) {
				for(int j=i-1; j>0; j--) {
					dp[j][i] = Integer.MAX_VALUE;
					for(int m=j; m<=i; m++) {
						dp[j][i] = Math.min(dp[j][i], dp[j][m]+dp[m+1][i]);
					}
					dp[j][i] += sum[i] - sum[j-1];
				}
			}
			sb.append(dp[1][K]).append("\n");
		}
		System.out.print(sb);
	}

}
