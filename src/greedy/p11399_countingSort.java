package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11399_countingSort {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] counting = new int[1001];
		for(int i=0; i<N; i++) {
			counting[Integer.parseInt(st.nextToken())] += 1;
		}
		
		int sum=0; int wait =0;
		for(int i=0; i<1001; i++) {
			if(counting[i] > 0) {
				for(int j=0; j<counting[i]; j++) {
					wait += i;
					sum += wait;
				}
			}
		}
		
		System.out.print(sum);

	}

}
