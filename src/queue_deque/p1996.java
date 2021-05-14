package queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1996 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		
		
		//�Է½� �ε����� �߿䵵 �Բ� ����.
		LinkedList<int[]> list;
		
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {//for�� �ϸ� �ȵ�..while�� �ؾ� T-- >0 �� �� ����
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());//���� ����
			int M = Integer.parseInt(st.nextToken());//�ε���
			
			st = new StringTokenizer(br.readLine(), " ");
			list = new LinkedList<>();
			for(int i=0; i<N; i++) {
				list.offer(new int[] {i, Integer.parseInt(st.nextToken()) } );
			}
			
			int count = 0;
			while(!list.isEmpty()) {
				
				int[] front = list.poll();
				boolean isMax = true;
				
				for(int i=0; i<list.size(); i++) {
					if(front[1] < list.get(i)[1]) {//�� ó���� ���� ũ��
						list.offer(front);//���� poll�س����� offer���ְ�
						for(int j=0; j<i; j++) {//���� �͸�ŭ �ڷ� ������
							list.offer(list.poll());
						}
						
						isMax = false; //ù��°�� 1������ �ƴϾ��⿡ false�� �ٲ���
						break;
					}
				}
				
				if(isMax) {
					count++;
					if(front[0] == M) {
						sb.append(count).append("\n");
						break;
					}
				}else {
					continue;
				}
			}
			
		}
		System.out.print(sb);

	}

}
