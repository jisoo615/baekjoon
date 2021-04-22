package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//340ms
public class p1912_recur {
	static int[] arr;
	static int N;
	static Integer[] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N]; dp = new Integer[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		
		recur(N-1);
		
		int max = arr[0];//음수만 있을 경우도 있기 떄문에 0으로 초기화 하면 안됨
		for(int x : dp) {
			max = Math.max(x, max);
		}
		System.out.print(max);
		
	}
	
	public static int recur(int n) {
		if(dp[n] == null) {
			dp[n] = Math.max(recur(n-1) +arr[n], arr[n]);
		}
		return dp[n];
	}

}
