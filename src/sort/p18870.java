package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class p18870 {
//좌표정렬_시간초과
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		int[] arr = new int[n];
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(temp[i]);
			
			//중복제거 하면서 list에 넣기-순위용
			if(!list.contains(arr[i])) {
				list.add(arr[i]);
			}
		}
	
		Collections.sort(list); //순위정렬
		//arr값과 같은 list의 인덱스값 출력
		StringBuilder sb = new StringBuilder();
		for(int k=0; k<n; k++) {
			sb.append(Collections.binarySearch(list, arr[k])+" ");//이진탐색
		}System.out.println(sb);
	}

}
