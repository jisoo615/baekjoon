package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//가장 긴 바이토닉 부분 수열
public class p11054 {
	public static int N;
	public static int[] arr;
	public static Integer[] I_dp, D_dp;//오름차순 개수, 내림차순 개수 담는 배열

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		I_dp = new Integer[N]; D_dp = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			LIS(i); LDS(i);
		}
		
		int max =Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			max = Math.max(I_dp[i] + D_dp[i], max);
		}
		
		System.out.print(max-1);
	}
	
	public static int LIS(int n) {//n노드 이전에 작은게 있으면 +1--11053에서 한것
		if(I_dp[n]==null) {
			I_dp[n] = 1;//1로 초기화
			for(int i=n-1; i>=0; i--) {
				if(arr[i] < arr[n]) {
					I_dp[n] = Math.max(I_dp[n], LIS(i)+1);
				}
				}
			}
		return I_dp[n];
	}
	
	public static int LDS(int n) {//n이후 노드중 작은게 있으면 +1
		if(D_dp[n]==null) {
			D_dp[n] = 1;//1로 초기화
			for(int i=n+1; i<N; i++) {
				if(arr[i] < arr[n]) {
					D_dp[n] = Math.max(D_dp[n], LDS(i)+1);
				}
				}
			}
		return D_dp[n];
	}

}
