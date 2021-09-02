package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2470 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        Long[] arr = new Long[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(arr);
        Long a = null, b=null;
        long almostZero = Integer.MAX_VALUE;
        int start =0;
        int end = n-1;
        while(start < end) {
        	long sum = arr[start]+arr[end];
        	
        	if(Math.abs(sum) < almostZero ) {//계속 더 작은 수를 저장할수 있게함
        		a = arr[start];
        		b = arr[end];
        		almostZero = Math.abs(sum);
        	}
        	
        	if(sum < 0) {//커져야됨
        		start++;
        	}else {//작아져야됨
        		end--;
        	}
        }
        
        System.out.println(a+" "+b);

	}

}
