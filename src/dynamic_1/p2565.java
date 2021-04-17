package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
//전깃줄 재귀 top-down방식
//역발상: 제거 개수를 세는게 아니라 설치가능 개수를 구하자
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
		Arrays.sort(arr, new Comparator<int[]>() {//A로 오름차순, A가 같으면 B오름차순
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0]; //arr[i] = {x, y}니까
			}}
		);
		//최대연결 가능 전깃줄 개수 구하자
		int max =0;
		for(int i=1; i<dp.length; i++) {
			max = Math.max(recur(i), max);
		}
		System.out.print(N-max);
		
	}
	
	static int recur(int n) {
		if(dp[n]==null) {
			dp[n]= 1;//최솟값 1로 초기화
			
			for(int i=n+1; i<dp.length; i++) {
				
				if(arr[n][1] < arr[i][1]){//B가 더 클때만 dp에 저장
					dp[n] = Math.max(dp[n], recur(i) + 1);//+1하는 이유: i는 n다음 전깃줄도 설치한다는 뜻->그래서 1씩 더해서 저장해주는 거임
				}
			}
		}
		
		return dp[n];
	}

}
