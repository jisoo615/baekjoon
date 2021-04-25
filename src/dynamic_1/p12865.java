package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p12865 {
//평범한 배낭
	public static int[] W, V;
	public static Integer[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//넣을까 말까 한 물건 갯수
		int K = Integer.parseInt(st.nextToken());//견딜수 있는 무게kg
		W = new int[N];//무게
		V = new int[N];//가치
		dp = new Integer[N][K+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i]= Integer.parseInt(st.nextToken());
			V[i]= Integer.parseInt(st.nextToken());
		}
		
		System.out.print(knapsack(N - 1, K));

	}
	
	static int knapsack(int i, int k) {
		// i가 0미만, 즉 범위 밖이 된다면
		if (i < 0)
			return 0;
			
		// 탐색하지 않은 위치라면?
		if (dp[i][k] == null) {
				
			// 현재 물건(i)을 추가로 못담는 경우 (이전 i값 탐색) 
			if(W[i] > k) {
				dp[i][k] = knapsack(i - 1, k);
			}
			// 현재 물건(i)을 담을 수 있는 경우 
			else if (W[i] <= k) {
				// 이전 i값과 이전 i값에 대한 k-W[i]의 값 + 현재 가치(V[i])중 큰 값을 저장  
				dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - W[i]) + V[i]);
			}
		}
		return dp[i][k];
	}

}
