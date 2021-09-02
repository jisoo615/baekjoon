package twoPointer;

import java.util.*;
import java.io.*;
//시간초과
//오름차순 + 이분탐색 + 쌍을 구하는 것이니 정답에서 /2를 할것 :(a,b)=(b,a)
public class p3273{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        
        int count = 0;
        Arrays.sort(arr);
        
        int high = n-1;
        int low = 0;

        while(low < high) {  
        	
        	int sum = arr[low]+arr[high];
        	
        	if(sum > m) {
        		high--;
        	}
        	else if(sum < m) {
        		low++;
        	}
        	else {//sum == m
        		count++;
        		low++;//범위를 양쪽에서 한칸씩 줄여줌
        		high--;
        	}
        }
        
        System.out.print(count);
    }
}