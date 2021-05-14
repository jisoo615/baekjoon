package queue_deque;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p11866 {
//1���� N������ �� �� k��° �ִ� ���� ���� ��� ���. �� ť�� �ɶ����� 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int j=0; j<N-1; j++) {//�������� , �� ������ؼ� �ϳ� ���� ��
			for(int i=0; i<K-1; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll()).append(", ");
		}
		sb.append(q.poll()).append(">");
		System.out.print(sb);
		
		sc.close();

	}

}
