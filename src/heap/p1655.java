package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class p1655 {
//������� ���ض�. -> �ּ����� �ִ��� �� �� ����ؼ� Ǯ��
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		StringBuilder sb = new StringBuilder();
		
		int x = Integer.parseInt(br.readLine());
		//�� ù��° ���� �� �ִ����� �־��ְ� sb�� �ֱ�
		maxHeap.add(x);
		sb.append(maxHeap.peek()).append("\n");
		
		for(int i=0; i<N-1; i++) {
			
			x = Integer.parseInt(br.readLine());
			
			if( minHeap.isEmpty() || x < minHeap.peek() ) {//�ּ����� ����ų� x�� �ּ����� ��Ʈ���� ������
				maxHeap.add(x);
			}else {//�ּ����� ������� �ʰ�, x�� �ּ����� ��Ʈ���� ������
				minHeap.add(x);
			}
			
			int differ= maxHeap.size() - minHeap.size();
			if(differ < 0) {//�ּ����� �� Ŭ��
				maxHeap.add(minHeap.poll());
			}
			else if(differ >= 2){//�ִ����� 2�̻� Ŭ��
				minHeap.add(maxHeap.poll());
			}
			
			sb.append(maxHeap.peek()).append("\n");
		}
		
		
		System.out.print(sb);

	}

}
