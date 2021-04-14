package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1149_1 {
	final static int red = 0;
	final static int green =1;
	final static int blue =2;
	public static int[][] cost;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		cost = new int[N][3];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cost[i][red]=Integer.parseInt(st.nextToken());
			cost[i][green]=Integer.parseInt(st.nextToken());
			cost[i][blue]=Integer.parseInt(st.nextToken());
		}
	
		for(int i=1; i<N; i++) {
			cost[i][red] += Math.min(cost[i-1][blue], cost[i-1][green]);
			cost[i][blue] += Math.min(cost[i-1][red], cost[i-1][green]);
			cost[i][green] += Math.min(cost[i-1][blue], cost[i-1][red]);
		}
		System.out.print(Math.min(cost[N-1][red], Math.min(cost[N-1][blue], cost[N-1][green])));
	}

}
