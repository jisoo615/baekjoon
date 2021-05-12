package queue_deque;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		while(q.size() > 1) {// poll�� �ι������� offer�ѹ� �ؼ� 
			q.poll();		//1�� �پ��� ������ while�� �ȿ� break �־��� �ʿ� ����
			int item = q.poll();
			q.offer(item);
		}
		
		System.out.println(q.poll());
		
		
		//array�� Ǯ���
		int[] arr = new int[N*2];//�������� �ʰ� ��� �ڿ� �߰��ϴµ� �ε����� ������ ����
		for(int i=1; i<=N; i++) {
			arr[i] = i;//�ε��� 0�� �Ⱦ�
		}
		int prev_indx = 1;
		int last_indx = N;
		
		while(N-- > 1) {// '1' 2 3 4 5 '6'
			prev_indx += 1;//ó���� ���� 1 '2' 3 4 5 '6'
			
			last_indx +=1;
			arr[last_indx] = arr[prev_indx];//�� �������� �� �ڷ� �߰���. 1 '2' 3 4 5 6 '2'
			prev_indx +=1;	// 1 2 '3' 4 5 6 '2'
		}
		
		System.out.print(arr[prev_indx]);
		
		sc.close();

	}

}
