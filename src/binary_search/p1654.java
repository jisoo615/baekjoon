package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1654 {
	public static long[] arr;
	public static long max;
	public static int k, n;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		//����  x �� ���� ����� ���� n�� �̻��� �Ǿ�� ��.
		
		arr = new long[k];
				
		for(int i=0; i<k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		System.out.print((int)binarySearch_findLength(n));
		

	}
	
	public static long binarySearch_findLength(long n) {
		long start =1; long end = max;
		long mid;
		long answer=0;
		
		while(start <= end) {/*���������� �ؾ� 
							**1 1 
							5 �϶�- �ùٸ� ���: 5, Ʋ�� ���: 4 ���� ����.*/
			int cnt =0;//cnt �ʱ�ȭ
			mid = (start+end)/2;
			
			for(int i=0; i<arr.length; i++) {
				cnt += arr[i]/mid;
			}
			
			if(cnt >= n) {//���� �÷��ߵ�
				answer = mid;//n�� �̻��� �ִ� ���� ���ض�
				start = mid+1;
			}else {//���� �ٿ�����
				end = mid-1;
			}			
		}
		
		return answer;
	}

}
