package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p11650_2 {
//좌표정렬 comparator 객체를 따로 만든 후 정렬해보기
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Comparator<int[]> comparator = new Comparator<int[]>() {
			@Override
			public int compare(int[] e1, int[] e2) {
				if(e1[0]==e2[0]) {
					return e1[1] -e2[1];
				}
				else {
					return e1[0] -e2[0];
				}
			}
		};
		
		Arrays.sort(arr, comparator);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(arr[i][0]+" "+arr[i][1]+"\n");
		}
		System.out.print(sb);

	}

}
