package dynamic_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p1520_2 {
	static int N, M, arr[][], dp[][];
	
	public static void main(String [] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		arr= new int[N+1][M+1];
		dp= new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Arrays.fill(dp[i], -1); //dp값 -1로 초기화
			for(int j=1; j<=M; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dp_find(1, 1));
	}
	
	public static int dp_find(int sn, int sm) { //startN, startM: 시작위치
		if(N==sn && M==sm) { // (N, M)에 도착하면 종료
			return 1;
		}
		
		if(dp[sn][sm]==-1) { //sn, sm 지점 탐색 여부= 탐색한적 없으면 -1
			dp[sn][sm]= 0;
			
            //상하좌우 확인
			if(sn>0 && arr[sn][sm] > arr[sn-1][sm]) {
				dp[sn][sm]+=dp_find(sn-1, sm);
			}
			if(sm>0 && arr[sn][sm] > arr[sn][sm-1]) {
				dp[sn][sm]+=dp_find(sn, sm-1);
			}
			if(sn<N && arr[sn][sm] > arr[sn+1][sm]) {
				dp[sn][sm]+=dp_find(sn+1, sm);
			}
			if(sm<M && arr[sn][sm] > arr[sn][sm+1]) {
				dp[sn][sm]+=dp_find(sn, sm+1);
			}
		}
		return dp[sn][sm];
	}//end dp
}