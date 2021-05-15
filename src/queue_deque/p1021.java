package queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1021 {

	public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			LinkedList<Integer> dq = new LinkedList<>();
			int[] seq = new int[M];
			StringBuilder sb = new StringBuilder();
			
			for(int i=1; i<=N; i++) {
				dq.offer(i);
			}// 1~N���� �ִ� ��
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<M; i++) {
				seq[i] = Integer.parseInt(st.nextToken());
			}//�������� ��
			
			int count =0;
			for(int i=0; i<M; i++) {
				int target_indx = dq.indexOf(seq[i]);
				int half_indx;//�߰����� �ε���
				if(dq.size() %2 == 0) {//dq�� �ε����� 0���� �������� �����ؾ���. 
					half_indx = dq.size() / 2 -1;// 1~8 �̸� �߾Ӱ���4. �ε����� 3
				}else {//���̰� Ȧ����
					half_indx = dq.size() / 2; // 1~7 �̸� �߾Ӱ���4, �ε����� 3
				}
				
				//2, 3�� ����
				if(target_indx <= half_indx) {// target ... half
					for(int j=0; j<target_indx; j++) {
						dq.offerLast(dq.pollFirst());
						count++;
					}
				}else {
					for(int j=0; j<dq.size()-target_indx; j++) {
						dq.offerFirst(dq.pollLast());
						count++;
				}
			}
				dq.poll();
			}
			System.out.print(count);
	}
			
}
