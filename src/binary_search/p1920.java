package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1920 {
	public static int[] arr;

	public static void main(String[] args) throws IOException {
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
		
		st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			
			// ã���� �ϴ� ���� ���� ��� 1, ���� ��� 0�� ����ؾ��Ѵ�.
			if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append('\n');
			}
			else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	
	/**
	 * @param key ã������ ��
	 * @return key�� ��ġ�ϴ� �迭�� �ε���
	 */
	public static int binarySearch(int key) {
		int lo = 0; 				// Ž�� ������ ���� �� �ε��� lowest
		int hi = arr.length - 1;	// Ž�� ������ ������ �� �ε��� highest
		
		while(lo <= hi) {
			int mid = (lo+hi)/2;
			
			if(key < arr[mid]) {//ã�� ���� �� ������ ���� Ž���ϰ� �ؾߵ�
				hi = mid-1;
			}
			else if(key > arr[mid]) {//ã�� ���� �� ũ�� ������ Ž���ϰ� �ؾߵ�
				lo = mid+1;
			}
			else{
				return mid;
			}
		}
		
		return -1;//�������� ���� ��� -1 ��ȯ
	}

}
