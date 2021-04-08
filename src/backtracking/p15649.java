package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15649 {
//1���� N������ ���� M�� ¥�� ���� ��� ����ض�
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		arr = new int[M];//��µ� ������
		visit = new boolean[N];//�ε���(+1)������ �湮����
		
		dfs(N, M, 0);
		System.out.print(sb);
	}
	
	public static void dfs(int N, int M, int depth) {
		
		if(depth == M) {
			for(int val : arr) {
				sb.append(val+" ");
			}sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visit[i]==false) {
				visit[i] = true;
				arr[depth] = i+1;
				
				dfs(N, M, depth+1);//���ȣ��� ++��� +1�ϱ�: ++ �� depth ������ �� ��ü�� 1 �����ϱ� ������ ��Ϳ��� �������͵� ������ ���� �״�� �����Ǳ� ����
				visit[i] = false; //�湮�ϰ� �������� �ٽ� false�� �ٲ���� �ٸ� �갡 �湮�� �� �� �� �ִ�.				
			}
		}
		
	}

}
