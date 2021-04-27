package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p13305 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] distance = new long[N-1];
		long[] price = new long[N];
				
		for(int i=0; i<N-1; i++) {
			distance[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			price[i] =  Long.parseLong(st.nextToken());
		}
		
		
		long sum=0; //long으로 바꿔주기
		long minPrice = price[0];
		
		for(int i=0; i<N-1; i++) { //5 2 4 1 -> 5 2 2 1
			if(price[i] < minPrice ) {//최소 가격있으면 갱신해주기
				minPrice = price[i];	
			}
			
			//price * distance
			sum += (minPrice * distance[i]);
		}

		System.out.print(sum);

	}

}
