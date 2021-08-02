package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2110 {
	public static long N;
	public static long C;
	public static long[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new long[(int)N];
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		System.out.print(binarySearch(C));
		
	}
	
	public static long binarySearch(long c) {
		long start=1; long end = arr[arr.length-1];
		long mid = 0;	int cnt = 0;
		long answer = 0;
		
		while(start <= end) {
			mid = (start+end)/2;
			
			cnt = installWifi(mid);
			
			if(cnt >= c) {//공유기를 줄여야할때, 갭 늘여야함	//요 조건문 주의
				start = mid+1;
				answer = mid;
			}else {//공유기를 더 설치해야될때 갭 줄여야함.
				end = mid-1;
			}
		}
		
		return answer;
	}
	
	public static int installWifi(long gap) {
		int indx=0;
		int cnt = 1;//공유기가 arr[0]에 초기에 설치되어있다고 가정하고
		for(int i=1; i<N; i++) {
			if(arr[i]-arr[indx] >= gap) {//거리가 갭보다 넓으면 그 집에 공유기 설치
				cnt+=1;
				indx=i;//방금 설치한 얘랑 비교하려고/
			}
		}
		
		return cnt;
	}

}
