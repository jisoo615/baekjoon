package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1932 {
	public static int[][] tri;
	public static int[][] dp;
	public static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tri = new int[N][N];
		dp = new int[N][N];
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<i+1; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			dp[N-1][i] = tri[N-1][i];
		}
		
		System.out.print(tri_max(0, 0));

	}
	
	public static int tri_max(int depth, int i) {
		if(depth==N-1) {
			return dp[depth][i];
		}
		
		if(dp[depth][i]==0) {
			return dp[depth][i] =Math.max(tri_max(depth+1, i), tri_max(depth+1, i+1)) + tri[depth][i];//추가로 dp더하는게 아니라 tri더하기
		}
		return dp[depth][i];
	}
	
}
