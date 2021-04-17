package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//포도주 시식
//재귀 top-down 방식 계단오르기와 비슷(2579) 
//계단오르기와 더룬 점: 뒷 순서일 수록 크다는 보장이 없기 때문에, n번째를 포함할때와 n전꺼가 더 큰지 비교해줘야 함.
public class p2156 {
	public static Integer[] dp;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N+1];
		arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0]=0; dp[1] = arr[1];
		if(N>=2) {
			dp[2] = arr[1]+arr[2];
		}
		
		System.out.print(recur(N));
	}
	
	public static int recur(int n) {
		if(n==1) {
			return dp[1];
		}
		if(dp[n]==null) {
			dp[n] = Math.max( Math.max(recur(n-2), recur(n-3)+arr[n-1]) + arr[n],//n까지 포함했을때랑 n-1까지 더했을때랑 비교하기 위해
								recur(n-1));
		}
		
		return dp[n];
	}

}
