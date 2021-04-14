package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1149 {
	final static int red = 0;
	final static int green =1;
	final static int blue =2;
//RGB거리
	public static int[][] cost;
	public static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		cost = new int[N][3];
		dp = new int[N][3];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cost[i][red]=Integer.parseInt(st.nextToken());
			cost[i][green]=Integer.parseInt(st.nextToken());
			cost[i][blue]=Integer.parseInt(st.nextToken());
		}
		
		dp[0][red] = cost[0][red];
		dp[0][green] = cost[0][green];
		dp[0][blue] = cost[0][blue];
		
		int redFirst = paint(N-1, red);
		int greenFirst = paint(N-1, green);
		int blueFirst = paint(N-1, blue);
		
		int answer = Math.min(redFirst, greenFirst);
		answer = Math.min(answer, blueFirst);
		
		System.out.print(answer);

	}
	
	public static int paint(int n, int color) {
		if(dp[n][color] == 0) {
			//현재dp = 전에 작은 비용 선택+현재 색 비용
			if(color==red) { 
				dp[n][red] = Math.min(paint(n-1, green), paint(n-1, blue))+cost[n][red];
			}
			else if(color==green) {
				dp[n][green] = Math.min(paint(n-1, red), paint(n-1, blue))+cost[n][green];
			}
			else if(color==blue) {
				dp[n][blue] = Math.min(paint(n-1, red), paint(n-1, green))+cost[n][blue];
			}
		}
			
		return dp[n][color];
	}
	
	
	
}
