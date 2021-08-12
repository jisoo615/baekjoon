package dynamic_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2293 {
	static int arr[], dp[], n, cost;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		cost = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		dp = new int[cost+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1;
		for(int i=1; i<=n; i++) {
			for(int j=arr[i]; j<=cost; j++) {
				dp[j] += dp[j - arr[i]];
			}
		}
		
		System.out.print(dp[cost]);
		
	}

}
