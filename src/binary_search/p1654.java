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
		//끈을  x 로 나누 몫들의 합이 n개 이상이 되어야 함.
		
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
		
		while(start <= end) {/*같을때까지 해야 
							**1 1 
							5 일때- 올바른 출력: 5, 틀린 출력: 4 되지 않음.*/
			int cnt =0;//cnt 초기화
			mid = (start+end)/2;
			
			for(int i=0; i<arr.length; i++) {
				cnt += arr[i]/mid;
			}
			
			if(cnt >= n) {//줄을 늘려야됨
				answer = mid;//n개 이상일 최대 길이 구해라
				start = mid+1;
			}else {//줄을 줄여야함
				end = mid-1;
			}			
		}
		
		return answer;
	}

}
