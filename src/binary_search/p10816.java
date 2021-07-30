package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p10816 {
	public static int[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//Ž���� �迭�� ������ �Ǿ��־�� ��,
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			int findNum = Integer.parseInt(st.nextToken());
			
			if( findNum == arr[ lower_bound(findNum) ] ) {//ã�� ���ڰ� ���� �� 0 ����ؾ� �ϴϱ�
				
				if( upper_bound(findNum) == N-1 ) {//�Ʒ� ����** �ּ� ���� �� �κ�
					sb.append(upper_bound(findNum)-lower_bound(findNum) + 1);
				}else {
					sb.append(upper_bound(findNum)-lower_bound(findNum));
				}
			}
			else {
				sb.append("0");
			}
			sb.append(" ");
			
		}/**
		 ���� ** arr�� �ִ� �� ������ ��(10)�� ã�� upper_bound�� 9�� �������̴�. ���ڰ� �� ū�� �������� 10�ε�. �׷��� ���� �������.
		 **/
		
		System.out.print(sb);

	}
	
	
	public static int lower_bound(int findNum) {//ã���� �ϴ� ���ڰ� ó�� ������ �ڸ�
		int start=0; int end= arr.length-1; 
		int mid;
		
		while(start < end) {
			mid = (start+end)/2;
			
			if(arr[mid] >= findNum) {//ã������ ������ �۰ų� ���� ���� ã�´�. 
				end = mid;
			}else {
				start = mid+1;
			}
		}
		
		return end;
	}
	
	public static int upper_bound(int findNum) {//ã������ ������ ó���׷� �� ū ���� �ڸ�
		int start=0; int end= arr.length-1; 
		int mid;
		
		while(start < end) {
			mid = (start+end)/2;
			
			if(arr[mid] > findNum) {//ã������ ������ ū ���� ã�´�.
				end = mid;
			}else {
				start = mid+1;
			}
		}
		
		return end;
	}

}
