package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9251 {
//LCS
	static char[] str1;
	static char[] str2;
	static Integer[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		
		dp = new Integer[str1.length][str2.length];
		
		System.out.print(LCS(str1.length -1, str2.length -1));

	}
	
	static int LCS(int x, int y) {
		// 인덱스 밖 (공집합)일 경우 0 반환
		if(x == -1 || y == -1) {
			return 0;
		}
				
		if(dp[x][y]==null) {
			dp[x][y] = 0;
			
			if(str1[x] == str2[y]) {
				dp[x][y] = LCS(x-1, y-1) + 1;
			}
			else {
				dp[x][y] = Math.max(LCS(x-1, y), LCS(x, y-1));
			}
		}
		
		return dp[x][y];
	}

}
