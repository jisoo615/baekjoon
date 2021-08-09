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
		for(int i=1; i<=n; i++) {//���̰� 1�϶�
			dp[i][i] = true;
		}
		for(int i=1; i<n; i++) {//���̰� 2�϶�
			if(arr[i]==arr[i+1]) {
				dp[i][i+1] = true;
			}
		}
		
		for (int i = 2; i < N; i++) {//i�� ����
			for (int j = 1; j <= N - i; j++) {//j�� ������
            	//�� �ڰ� ����(arr), �� �� ���̿� �ִ� ����(dp)���� �Ӹ������ ���
                if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1])
                       dp[j][j + i] = true;
            }
		}
	}
}
