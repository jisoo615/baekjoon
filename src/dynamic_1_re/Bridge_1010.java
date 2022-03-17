package dynamic_1_re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 팩토리얼로 구할 시 최대 30!까지 구해야 하는데 dp를 Long 타입으로 선언해도 범위 넘어감 -> -나옴, 팩토리얼 말고 다른 방법
 * 조합을 dp로 구현 -> int 타입으로 dp선언해도 됨
 */
// https://www.acmicpc.net/problem/1010
//다리놓기
public class Bridge_1010 {
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		/**
		 * 입툴력 받기
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		dp = new int[31][31];
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);

			sb.append(find(M, N)).append("\n");

		}
		br.close();
		System.out.println(sb.toString());
	}

	/**
	 * m 개중에 중복없이(순서없이) n개 고르는 조합 nCr = n! / r!(n-r)! = n-1Cr + n-1Cr-1
	 * nCn=1, nC0=1
	 */
	static int find(int n, int r) {
		if(dp[n][r]>0) return dp[n][r];
		if(n==r) return dp[n][r]=1;
		if(r==0) return dp[n][r]=1;

		dp[n-1][r] = find(n-1, r);
		dp[n-1][r-1] = find(n-1, r-1);
		return dp[n-1][r] + dp[n-1][r-1];
	}

}
