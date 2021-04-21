package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11054_bottomUp {
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
			
			
			for(int i=0; i<N; i++){//LIS//0에서 부터
				I_dp[i] =1;
				
				for(int j=0; j<i; j++) {
					if(arr[j] < arr[i] && I_dp[i]<I_dp[j]+1) {
						I_dp[i] = I_dp[j]+1;
					}
				}
			}
			
			for(int i=N-1; i>=0; i--){//LDS//뒤에서부터
				D_dp[i] =1;
				
				for(int k=N-1; k>i; k--) {
					if(arr[k] < arr[i] && D_dp[i]<D_dp[k]+1) {
						D_dp[i] = D_dp[k]+1;
					}
				}
			}
				
			
			int max = -1;
			for(int i=0; i<N; i++) {
				max = Math.max(I_dp[i] + D_dp[i], max);
			}
			
			System.out.print(max-1);

	}

}
