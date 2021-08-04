package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class p11279 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());//최대힙은 큰 수가 우선순위라 reverseOrder()해줘야함
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			
			int x = Integer.parseInt(br.readLine());
			
			if( x == 0 ) {
					if(priority.isEmpty()) {
						sb.append(0).append("\n");
					}else {
						sb.append(priority.poll()).append("\n");
					}
			}else {//order > 0
				priority.add( x );
			}
		}
		
		System.out.print(sb);

	}

}
