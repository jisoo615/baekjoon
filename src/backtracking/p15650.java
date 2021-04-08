package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1~N까지 오름차순인 M개의 수열을 출력해라.
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
		
		for(int i=start; i<N; i++) {//i를 0이 아니라 start부터 돌도록
			if( visit[i]==false) {
				visit[i] = true;
				arr[depth] = i+1;
				dfs(i+1,depth+1);//start를 현재 노드의 값+1해줘서 오름차순인 수열만 만들어지도록 
				visit[i] = false;
			}
		}
	}

}
