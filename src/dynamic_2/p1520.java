package dynamic_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1520 {
	static int N, M, arr[][], dp[][];
	static StringBuilder sb= new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Arrays.fill(dp[i], -1);//dp를 -1로 초기화
			for(int j=1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(dfs(1, 1));

	}
	
	static int dfs(int sn, int sm) {
		if(sn==N && sm==M) {//M, N에 도착하면 종료
			return 1;
		}
		if(dp[sn][sm]==-1) {
			dp[sn][sm] = 0;//처음 지나가는 곳 0으로 바꿔주기
		
			//상하좌우 확인
			if(sn>0 && arr[sn][sm] > arr[sn-1][sm]) {
				dp[sn][sm] += dfs(sn-1, sm);
			}
			if(sm>0 && arr[sn][sm] > arr[sn][sm-1]) {
				dp[sn][sm] += dfs(sn, sm-1);
			}
			if(sn<N && arr[sn][sm] > arr[sn+1][sm]) {
				dp[sn][sm] += dfs(sn+1, sm);
			}
			if(sm<M && arr[sn][sm] > arr[sn][sm+1]) {
				dp[sn][sm] += dfs(sn, sm+1);
			}
		}
		
		return dp[sn][sm];
	}

}
