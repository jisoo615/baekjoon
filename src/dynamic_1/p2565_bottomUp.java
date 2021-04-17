package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p2565_bottomUp {
//������ �ݺ��� bottom-up���
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[N+1][2];
		Integer[] dp = new Integer[N+1];
		
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
		
		for(int i=1; i<dp.length; i++) {
			dp[i]=1;
			for(int j=1; j<i; j++) {
				if(arr[i][1] > arr[j][1]) {
					dp[i] = Math.max(dp[i], dp[j]+1);//�� �̾����� +1�϶��Ҹ�
				}
			}
		}
		int max=0;
		for(int i=1; i<dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.print(N-max);
	}

}
