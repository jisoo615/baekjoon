package queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p10866 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			StringTokenizer command = new StringTokenizer(br.readLine(), " ");
			
			switch(command.nextToken()) {
			case "push_front" : q.addFirst(Integer.parseInt(command.nextToken()));
					break;
			case "push_back" : q.offer(Integer.parseInt(command.nextToken()));
					break;
			case "pop_front" : if(q.isEmpty()) {
									sb.append(-1).append("\n");
								}else sb.append(q.pollFirst()).append("\n");
					break;
			case "pop_back" : if(q.isEmpty()) {
								sb.append(-1).append("\n");
								}else sb.append(q.pollLast()).append("\n");
					break;
			case "size" : sb.append(q.size()).append("\n");
					break;
			case "empty" : if(q.isEmpty()) {
								sb.append(1).append("\n");
							}else sb.append(0).append("\n");
					break;
			case "front" : if(q.isEmpty()) {
								sb.append(-1).append("\n");
							}else sb.append(q.peekFirst()).append("\n");
					break;
			case "back" : if(q.isEmpty()) {
								sb.append(-1).append("\n");
							}else sb.append(q.peekLast()).append("\n");
					break;
			}
			
		}
		System.out.print(sb);

	}

}
