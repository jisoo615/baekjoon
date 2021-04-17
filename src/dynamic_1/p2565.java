package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
//������ ��� top-down���
//���߻�: ���� ������ ���°� �ƴ϶� ��ġ���� ������ ������
public class p2565 {
	public static int[][]arr;
	public static Integer[] dp;
	public static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[N+1][2];
		dp = new Integer[N+1];
		
		for(int i=1; i<arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {//A�� ��������, A�� ������ B��������
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0]; //arr[i] = {x, y}�ϱ�
			}}
		);
		//�ִ뿬�� ���� ������ ���� ������
		int max =0;
		for(int i=1; i<dp.length; i++) {
			max = Math.max(recur(i), max);
		}
		System.out.print(N-max);
		
	}
	
	static int recur(int n) {
		if(dp[n]==null) {
			dp[n]= 1;//�ּڰ� 1�� �ʱ�ȭ
			
			for(int i=n+1; i<dp.length; i++) {
				
				if(arr[n][1] < arr[i][1]){//B�� �� Ŭ���� dp�� ����
					dp[n] = Math.max(dp[n], recur(i) + 1);//+1�ϴ� ����: i�� n���� �����ٵ� ��ġ�Ѵٴ� ��->�׷��� 1�� ���ؼ� �������ִ� ����
				}
			}
		}
		
		return dp[n];
	}

}
