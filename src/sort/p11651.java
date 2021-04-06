package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11651 {
//좌표 정렬하기-11650과는 다르게 y오름차순 정렬+y같으면 x가 오름차순되게 정렬
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
		
		Arrays.sort(arr, (e1, e2)->{
			if(e1[1]==e2[1]) {
				return e1[0]-e2[0];//y가 같을때만 x오름차순
			}
			else return e1[1]-e2[1];//일단 y오름차순 양수:우선순위큼 0:같음 음수:우선순위낮음
		});

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(arr[i][0]+" "+arr[i][1]+"\n");
		}
		System.out.print(sb);
		
	}

}
