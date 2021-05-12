package queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p18258 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		Deque<Integer> q = new LinkedList<>();// deque임!! queue아니라
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			String command = st.nextToken();
			switch(command) {
				case "push" : q.offer(Integer.parseInt(st.nextToken())); break;
				
				case "pop" : Integer item = q.poll();//Integer타입임, 그래서 null도 표현o
					if(item == null) {
					sb.append("-1").append("\n");
				}else {
					sb.append(item).append("\n");
				}
					break;
					
				case "size" : sb.append(q.size()).append("\n");
					break;
					
				case "empty" :
					if(q.isEmpty()) {sb.append("1").append("\n");}
					else {sb.append("0").append("\n");}
					break;
					
				case "front" : Integer item2 = q.peek();
					if(item2 == null) {
						sb.append("-1").append("\n");
					}else {
						sb.append(item2).append("\n");
					}
					break;
					
				case "back" : Integer item3 = q.peekLast();
					if(item3 == null) {
						sb.append("-1").append("\n");
					}else {
						sb.append(item3).append("\n");
					}
					break;
			}
		}
		
		System.out.print(sb);

	}

}
