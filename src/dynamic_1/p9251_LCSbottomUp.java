package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//문자열 1000자리까지 테스트케이스라서, 반복문: 156ms  // 재귀: 232ms 시간 걸림 꽤 차이남
public class p9251_LCSbottomUp {

		static char[] str1;
		static char[] str2;
		static int[][] dp;
		
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			str1 = br.readLine().toCharArray();
			str2 = br.readLine().toCharArray();
			
			dp = new int[str1.length +1][str2.length +1];
			
			for(int i=1; i<=str1.length; i++) {
				for(int j=1; j<=str2.length; j++) {
					
						if(str1[i-1] == str2[j-1]){//문자배열은 1부터 시작 아니니까 -1해주기
							dp[i][j] = dp[i-1][j-1] +1;
						}
						else {
							dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
						}
				}
			}
			
			System.out.print( dp[str1.length][str2.length] );

	}

}
