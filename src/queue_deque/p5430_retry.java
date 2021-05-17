package queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class p5430_retry {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		
		ArrayDeque<Integer> deque;
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());//�׽�Ʈ ĳ�̽�
		
		while(T-- >0) {
			String command = br.readLine();//
			int N = Integer.parseInt(br.readLine());//
			st = new StringTokenizer(br.readLine(), "[],");//
			
			deque = new ArrayDeque<Integer>();
			
			for(int i=0; i<N; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			AC(command, deque);
		}
		
		System.out.print(sb);
	
	}
	
	public static void AC(String command, ArrayDeque<Integer> deque) {
		
		boolean isRight = true; //���������� �����ϴ°�?
		
		for(char cmd : command.toCharArray()) {
			
			if(cmd == 'R') {//Reverse: �ݴ�� �϶�
				isRight = !isRight; //���� �ٲ��ش�. 
				continue;//����� �Ʒ� �ڵ�� ����Ǹ� �ȵǴϱ� �� ���� ��ɾ�� �Ѿ��. 
			}
			
			if(isRight) {//���������� ������ ��� ����
				if(deque.pollFirst()==null) {//��������� erorr ���
					sb.append("error\n");
					return;//error�� ��� error�� ��µǾ�� �ϱ� ������ return���� �޼ҵ带 ������. 
				}
			}
			else {
				if(deque.pollLast()==null) {//��������� erorr ���
					sb.append("error\n");
					return;
				}
			}
			//deque �� �����ִ� ���ڵ鸸 ������ָ� �Ǳ� ������ ���⼭ �߰��� sb���� ���� ����,
		}//for�� end (command)
		
		//���� �޼ҵ尡 ������� ����.
		makePrintString(deque, isRight);
	}
	
	public static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {//revered������ ���ٷ� ����ؾߵż�.
		sb.append("[");
		
		if(deque.size() > 0) {//���Ұ� 1�� �̻��� ���� 
			if(isRight) {//�������϶�
				sb.append(deque.pollFirst());//ù��° ���� �ְ�
				while(!deque.isEmpty()) {
					sb.append(",").append(deque.pollFirst());// , ���� ����.
					//�̷��� �ϸ� ������ ���Ҵ� ,���� ���� �� ���� !!!!
				}
			}
			else {
				sb.append(deque.pollLast());//�� �� ���� �ְ�
				while(!deque.isEmpty()) {
					sb.append(",").append(deque.pollLast());// , ���� ����.
				}
			}
			
		}
		
		sb.append("]").append("\n");
		return;
		
	}

}
