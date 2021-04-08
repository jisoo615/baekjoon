package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//수열 중복은 안되지만, 수열 내 중복은 허용.
public class p15651 {
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
		
		dfs(0);
		System.out.print(sb);

	}
	
	public static void dfs(int depth) {
		if(depth==M) {
			for(int val : arr) {
				sb.append(val+" ");
			}sb.append("\n");
		return;
		}
		
		for(int i=0; i<N; i++) {
				visit[i] = true;
				arr[depth] = i+1;
				dfs(depth+1);
				visit[i] = false;
		}
	}
}
