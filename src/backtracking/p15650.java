package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1~N���� ���������� M���� ������ ����ض�.
public class p15650 {
	public static int N;
	public static int M;
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visit = new boolean[N];
		
		dfs(0, 0);
		System.out.print(sb);

	}
	
	public static void dfs(int start, int depth) {
		if(depth==M) {
			for(int val : arr) {
				sb.append(val+" ");
			}sb.append("\n");
		return;
		}
		
		for(int i=start; i<N; i++) {//i�� 0�� �ƴ϶� start���� ������
			if( visit[i]==false) {
				visit[i] = true;
				arr[depth] = i+1;
				dfs(i+1,depth+1);//start�� ���� ����� ��+1���༭ ���������� ������ ����������� 
				visit[i] = false;
			}
		}
	}

}
