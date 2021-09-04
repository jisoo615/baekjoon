package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//부분합 n범위는 100,000,000 -> answer=Float.MAX_VALUE 로 지정!!
public class p1806 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());//합
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start=0, end=0, cnt=0;
		double answer = Float.MAX_VALUE, sum=0;
		
		while(true) {
			if(sum >= s) {//줄여야됨
				answer = Math.min(answer, cnt);
				sum -= arr[start];
				cnt--;
				start++;
				
			}else {//sum < s 늘려야됨
				if(end==n) break;
				sum += arr[end];
				cnt++;
				end++;
			}
		}
		
		System.out.print(answer==Float.MAX_VALUE ? "0" : (int)answer );
		/**
		 * 주의 answer이 double 이므로 int형으로 바꿔 출력해야함.
		 */

	}
}
