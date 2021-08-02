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
		
		//탐색할 배열은 정렬이 되어있어야 함,
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			int findNum = Integer.parseInt(st.nextToken());
			int lower_indx = lower_bound(findNum);
			int upper_indx = upper_bound(findNum);
			
			if( findNum == arr[ lower_indx ] ) {//찾는 숫자가 없을 땐 0 출력해야 하니까
				
				if( upper_indx == N-1 ) {//아래 주의** 주석 보정 한 부분
					sb.append(upper_indx-lower_indx + 1);
				}else {
					sb.append(upper_indx-lower_indx);
				}
			
			}
			else {//찾는 숫자가 없을 땐 0 출력
				sb.append("0");
			}
			
			sb.append(" ");
			
		}/**
		 주의 ** arr에 있는 맨 마지막 수(10)를 찾는 upper_bound는 9가 마지막이다. 숫자가 더 큰게 많았으면 10인데. 그래서 보정 해줘야함.
		 **/
		
		System.out.print(sb);

	}
	
	
	public static int lower_bound(int findNum) {//찾고자 하는 숫자가 처음 나오는 자리(findNum 이하)
		int start=0; int end= arr.length-1; 
		int mid;
		
		while(start < end) {
			mid = (start+end)/2;
			
			if(arr[mid] >= findNum) {//찾으려는 수보다 작거나 같은 수를 찾는다. 
				end = mid;
			}else {
				start = mid+1;
			}
		}
		
		return end;
	}
	
	public static int upper_bound(int findNum) {//찾으려는 수보다 처으믕로 더 큰 수의 자리(findNum 초과)
		int start=0; int end= arr.length-1; 
		int mid;
		
		while(start < end) {
			mid = (start+end)/2;
			
			if(arr[mid] > findNum) {//찾으려는 수보다 큰 수를 찾는다.
				end = mid;
			}else {
				start = mid+1;
			}
		}
		
		return end;
	}

}
