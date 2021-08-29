package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//운동 플로이드 워셜 사용
public class p1956 {
	static int V, E, dp[][];
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dp = new int[V+1][V+1];
		for(int i=1; i<=V; i++) Arrays.fill(dp[i], INF);
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			dp[u][v] = d;
		}
		
		for(int mid=1; mid<=V; mid++) {
			for(int start=1; start<=V; start++) {
				for(int end=1; end<=V; end++) {
					dp[start][end] = Math.min(dp[start][mid]+dp[mid][end], dp[start][end]);
				}
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for(int i=1; i<=V; i++) {
				if(dp[i][i]!=INF && dp[i][i]!=INF) {
					answer = Math.min(answer, dp[i][i]);
				}
		}
		
		System.out.print(answer==Integer.MAX_VALUE ? "-1" : answer);

	}

}
