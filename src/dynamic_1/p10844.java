package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//���� ��� �� 456567
//��� top-down ��� (�� ū �ڱ�� ���� �ϴϱ� :1���ڸ��� �̸� 1�� ����Ǽ� �ʱ�ȭ ������, �� ū �ڸ����� �Ʒ��� �������� ������ �ƻ�)
public class p10844 {
	public static Long[][] dp;
	final static long MOD = 1000000000;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new Long[N+1][10];
		
		for(int i=0; i<10; i++) {//�� �����Ͽ� �ִ� ��
			dp[1][i] = 1L;
		}
		
		long result =0;
		for(int i =1; i <=9; i++) {//�� ���ʿ� �ִ� �ڸ��� ����Ǽ� �� ���ϱ�
			result += recur(N, i);
		}
		System.out.print(result % MOD);

	}
	//digit= �ڸ���
	public static long recur(int digit, int val) {
		if(digit==1) {
			return dp[1][val];
		}
		
		if(dp[digit][val]==null) {
			if(val==0) {
				dp[digit][0] = recur(digit-1, 1) ;
			}
			else if(val==9) {
				dp[digit][9] = recur(digit-1, 8);
			}
			else {
				dp[digit][val] = recur(digit-1, val-1) + recur(digit-1, val+1);
			}
		}
		
		return dp[digit][val] % MOD;
	}

}
