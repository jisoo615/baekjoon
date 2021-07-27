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
		
		//탐색할 배열은 정렬이 되어있어야 함,
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			
			// 찾고자 하는 값이 있을 경우 1, 없을 경우 0을 출력해야한다.
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
	 * @param key 찾으려는 값
	 * @return key와 일치하는 배열의 인덱스
	 */
	public static int binarySearch(int key) {
		int lo = 0; 				// 탐색 범위의 왼쪽 끝 인덱스 lowest
		int hi = arr.length - 1;	// 탐색 범위의 오른쪽 끝 인덱스 highest
		
		while(lo <= hi) {
			int mid = (lo+hi)/2;
			
			if(key < arr[mid]) {//찾을 값이 더 작으면 왼쪽 탐색하게 해야됨
				hi = mid-1;
			}
			else if(key > arr[mid]) {//찾을 값이 더 크면 오른쪽 탐색하게 해야됨
				lo = mid+1;
			}
			else{
				return mid;
			}
		}
		
		return -1;//존재하지 않을 경우 -1 반환
	}

}
