package dynamic_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10942 {
	static int N, M, arr[];
	static boolean dp[][];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new boolean[N+1][N+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		solve(arr, N);
		
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(dp[start][end]) sb.append("1\n");
            else sb.append("0\n");
		}
		
		System.out.print(sb);
		
	}
	
	static void solve(int[] arr, int n) {
		for(int i=1; i<=n; i++) {//길이가 1일때
			dp[i][i] = true;
		}
		for(int i=1; i<n; i++) {//길이가 2일때
			if(arr[i]==arr[i+1]) {
				dp[i][i+1] = true;
			}
		}
		
		for (int i = 2; i < N; i++) {//i는 간격
			for (int j = 1; j <= N - i; j++) {//j는 시작점
            	//앞 뒤가 같고(arr), 앞 뒤 사이에 있는 수들(dp)이이 팰린드롬인 경우
                if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1])
                       dp[j][j + i] = true;
            }
		}
	}
}
