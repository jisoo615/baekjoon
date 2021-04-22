package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//���ڿ� 1000�ڸ����� �׽�Ʈ���̽���, �ݺ���: 156ms  // ���: 232ms �ð� �ɸ� �� ���̳�
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
					
						if(str1[i-1] == str2[j-1]){//���ڹ迭�� 1���� ���� �ƴϴϱ� -1���ֱ�
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
