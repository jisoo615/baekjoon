package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class p1655 {
//가운데값을 말해라. -> 최소힙과 최대힙 둘 다 사용해서 풀이
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		StringBuilder sb = new StringBuilder();
		
		int x = Integer.parseInt(br.readLine());
		//맨 첫번째 수는 걍 최대힙에 넣어주고 sb에 넣기
		maxHeap.add(x);
		sb.append(maxHeap.peek()).append("\n");
		
		for(int i=0; i<N-1; i++) {
			
			x = Integer.parseInt(br.readLine());
			
			if( minHeap.isEmpty() || x < minHeap.peek() ) {//최소힙이 비었거나 x가 최소힙의 루트보다 작을때
				maxHeap.add(x);
			}else {//최소힙이 비어있지 않고, x가 최소힙의 루트보다 작을때
				minHeap.add(x);
			}
			
			int differ= maxHeap.size() - minHeap.size();
			if(differ < 0) {//최소힙이 더 클때
				maxHeap.add(minHeap.poll());
			}
			else if(differ >= 2){//최대힙이 2이상 클때
				minHeap.add(maxHeap.poll());
			}
			
			sb.append(maxHeap.peek()).append("\n");
		}
		
		
		System.out.print(sb);

	}

}
