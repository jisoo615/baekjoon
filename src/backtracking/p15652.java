package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15652 {
//비내림차순 11 12 13 22 23 33
	public static int N;
	public static int M;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		
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
		
		for(int i=start; i<N; i++) {//중복허용하지만 같거나 크도록 (비내림차순)
				arr[depth]=i+1;
				dfs(i, depth+1);
		}
		
	}

}
