package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15649 {
//1부터 N까지의 수로 M개 짜리 수열 모두 출력해라
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		arr = new int[M];//출력될 수열들
		visit = new boolean[N];//인덱스(+1)숫자의 방문여부
		
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
				
				dfs(N, M, depth+1);//재귀호출시 ++대신 +1하기: ++ 은 depth 변수의 값 자체가 1 증가하기 때문에 재귀에서 빠져나와도 증가된 값은 그대로 유지되기 떄문
				visit[i] = false; //방문하고 나왔으면 다시 false로 바꿔줘야 다른 얘가 방문할 때 들어갈 수 있다.				
			}
		}
		
	}

}
