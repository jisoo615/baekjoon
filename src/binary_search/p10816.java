package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p10816 {
	public static long[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		//이분탐색을 위해 미리 오름차순 정렬
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			int findNum = Integer.parseInt(st.nextToken());
			int lower_indx = lower_bound(findNum);
			int upper_indx = upper_bound(findNum);

			if( findNum == arr[ lower_indx ] ) {//ã�� ���ڰ� ���� �� 0 ����ؾ� �ϴϱ�
				sb.append(upper_indx-lower_indx + 1);
			}
			else {//ã�� ���ڰ� ���� �� 0 ���
				sb.append("0");
			}

			sb.append(" ");

		}

		System.out.print(sb);

	}


	public static int lower_bound(int findNum) {//처음으로 findNum 이상인 인덱스 위치-왼쪽에 위치
		int start=0; int end= arr.length-1;
		int mid;

		while(start < end) {
			mid = (start+end)/2;

			if(arr[mid] < findNum) {//ã������ ������ �۰ų� ���� ���� ã�´�.
				start = mid+1;
			}else {
				end = mid;
			}
		}

		return end;
	}

	public static int upper_bound(int findNum) {//처음으로 findNum을 초과하는 인덱스 위치-오른쪽에 위치
		int start=0; int end= arr.length-1;
		int mid;

		while(start < end) {
			mid = (start+end)/2+1;

			if(arr[mid] > findNum) {//ã������ ������ ū ���� ã�´�.
				end = mid-1;
			}else {
				start = mid;
			}
		}

		return end;
	}

}
