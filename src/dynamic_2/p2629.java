package dynamic_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2629 {
	static int n, weight[];//31
	static boolean dp[][];//31 30*500+1
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());	
		weight = new int[31];//�� �迭�� 0���� ���� �ִµ� 30�� �ƴ϶� 31�� ������, dfs���� weight[i+1]�ϸ� OutOfIndex���� ���� weight[i]�� ����
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		dp = new boolean[31][15001];//�ִ� ���� �� �ִ� ũ��� = ��� ���� ����.//31 sum+1
		
		dfs(0, 0);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			int bead = Integer.parseInt(st.nextToken());//bead = ���� = ������ ����
			if(bead > 15000) {//bead�� �ִ� ���� �� �ִ� ũ��(15000)���� ũ�� ������ N
				sb.append("N").append(" ");
				}
			else if(dp[n][bead]) {
				sb.append("Y").append(" ");
			}else {
				sb.append("N").append(" ");
			}
		}
		
		System.out.print(sb);

	}
	
	public static void dfs(int i, int w) {
		if( i>=n+1 ) return;//�������� ������ i�� n���� ũ�� ����(=i�� n���� ũ�� �����ض�)
		if(dp[i][w]) return;//���ߴ�, true�� ��� ����.
		dp[i][w] = true;
		dfs(i+1, w+weight[i]);//�߸� �� �ʿ� �ø�		//���⼭ ���� ���� ����' dp�� 1���� ����, weight�� 0���� �����̶�.
		dfs(i+1, Math.abs(w-weight[i]));//�߸� �����ʿ� �߰�
		dfs(i+1, w);//�߸� ���￡ ���� ����
	}

}
