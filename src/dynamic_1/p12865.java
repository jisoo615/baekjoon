package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p12865 {
//����� �賶
	public static int[] W, V;
	public static Integer[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//������ ���� �� ���� ����
		int K = Integer.parseInt(st.nextToken());//�ߵ��� �ִ� ����kg
		W = new int[N];//����
		V = new int[N];//��ġ
		dp = new Integer[N][K+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i]= Integer.parseInt(st.nextToken());
			V[i]= Integer.parseInt(st.nextToken());
		}
		
		System.out.print(knapsack(N - 1, K));

	}
	
	static int knapsack(int i, int k) {
		// i�� 0�̸�, �� ���� ���� �ȴٸ�
		if (i < 0)
			return 0;
			
		// Ž������ ���� ��ġ���?
		if (dp[i][k] == null) {
				
			// ���� ����(i)�� �߰��� ����� ��� (���� i�� Ž��) 
			if(W[i] > k) {
				dp[i][k] = knapsack(i - 1, k);
			}
			// ���� ����(i)�� ���� �� �ִ� ��� 
			else if (W[i] <= k) {
				// ���� i���� ���� i���� ���� k-W[i]�� �� + ���� ��ġ(V[i])�� ū ���� ����  
				dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - W[i]) + V[i]);
			}
		}
		return dp[i][k];
	}

}
