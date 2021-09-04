package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//�κ��� n������ 100,000,000 -> answer=Float.MAX_VALUE �� ����!!
public class p1806 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());//��
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start=0, end=0, cnt=0;
		double answer = Float.MAX_VALUE, sum=0;
		
		while(true) {
			if(sum >= s) {//�ٿ��ߵ�
				answer = Math.min(answer, cnt);
				sum -= arr[start];
				cnt--;
				start++;
				
			}else {//sum < s �÷��ߵ�
				if(end==n) break;
				sum += arr[end];
				cnt++;
				end++;
			}
		}
		
		System.out.print(answer==Float.MAX_VALUE ? "0" : (int)answer );
		/**
		 * ���� answer�� double �̹Ƿ� int������ �ٲ� ����ؾ���.
		 */

	}
}
