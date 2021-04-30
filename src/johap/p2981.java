package johap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2981 {

	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int gcdVal = arr[1] - arr[0];
		for(int i=2; i<N; i++) {
			gcdVal = GCD(gcdVal, arr[i] - arr[i-1]);
		}
		
		for(int i=2; i<=gcdVal; i++) {
			if(gcdVal %i==0) {
				sb.append(i+" ");
			}
		}
		
		System.out.print(sb);
		
	}
	
	static int GCD(int a, int b) {//a와 b의 최대공약수
		while(b!=0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}

}
