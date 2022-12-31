package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p12015_lowerbound {
	public static int N;
	public static int[] A;
	public static int[] arr;
	public static int length=1;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		arr[0] = A[0];
		for(int i=1; i<N; i++) {
			int value = A[i];
			if(value > arr[length-1]) {
				arr[length] = value;
				length += 1;
			}else {
				arr[lower_bound(value)] = value;
			}
		}

		System.out.print(length);
	}
	
	public static int lower_bound(int value) {//lower bound ����//**10816�� �� �����ص���.
		int start=0; int end= length-1; 
		int mid;
		
		while(start < end) {//"���ų�"�� ����!
			mid = (start+end)/2;
			
			if(arr[mid] >= value) {//ã������ ������ 'ũ�ų� ���� ��'�� ã�´�. "���ų��� ����"
				end = mid;
			}else {
				start = mid+1;
			}
		}
		
		return end;
	}

}
