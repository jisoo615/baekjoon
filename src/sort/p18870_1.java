package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class p18870_1 {
//백준_성공 2308ms
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(temp[i]);
	}
		int[] sortNums = arr.clone();//정렬용 하나 더 만들기
		Arrays.sort(sortNums);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int index=0;
		for(int x: sortNums) {
			if(!map.containsKey(x)) {
				map.put(x, index);//(숫자, 순위)
				index++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(map.get(arr[i])+" ");
		}System.out.print(sb);
	}
}
