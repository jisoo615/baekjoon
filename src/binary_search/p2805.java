package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2805 {
	static long n;
	static long m;
	static long[] trees;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		trees = new long[(int)n];
		for(int i=0; i<n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(trees);
		
		System.out.print(binarySearch(m));

	}
	
	public static long binarySearch(long m) {
		long start =1; long end = trees[trees.length-1];
		long mid; long takeout;
		long height_to_cut=0;
		
		while(start <= end) {
			mid = (start+end)/2;
			takeout = 0;//remains 초기화
			
			for(int i=0; i<trees.length; i++) {
				//나무가 남길 높이보다 작으먄 안쳐줌
				takeout += ( trees[i]>=mid ? trees[i]-mid : 0);
			}
			
			if(takeout >= m ) {//m이상 잘렸다면 높이를 더 높여야함. 
				height_to_cut = mid;
				start = mid+1;
			}else {//m미만을 잘렸다면 높이를 더 줄여야함. 
				end = mid-1;
			}
		}
		
		return height_to_cut;
	}

}
