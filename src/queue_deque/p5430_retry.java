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
		
		int T = Integer.parseInt(br.readLine());//테스트 캐이스
		
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
		
		boolean isRight = true; //정방향으로 연산하는가?
		
		for(char cmd : command.toCharArray()) {
			
			if(cmd == 'R') {//Reverse: 반대로 일때
				isRight = !isRight; //방향 바꿔준다. 
				continue;//지우는 아래 코드는 실행되면 안되니까 그 다음 명령어로 넘어간다. 
			}
			
			if(isRight) {//정방향으로 지워라 명령 실행
				if(deque.pollFirst()==null) {//비어있으면 erorr 출력
					sb.append("error\n");
					return;//error인 경우 error만 출력되어야 하기 때문에 return으로 메소드를 끝낸다. 
				}
			}
			else {
				if(deque.pollLast()==null) {//비어있으면 erorr 출력
					sb.append("error\n");
					return;
				}
			}
			//deque 에 남아있는 숫자들만 출력해주면 되기 떄문에 여기서 추가로 sb해줄 것이 없고,
		}//for문 end (command)
		
		//다음 메소드가 출력해줄 것임.
		makePrintString(deque, isRight);
	}
	
	public static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {//revered됐으면 꺼꾸로 출력해야돼서.
		sb.append("[");
		
		if(deque.size() > 0) {//원소가 1개 이상일 때만 
			if(isRight) {//정방향일때
				sb.append(deque.pollFirst());//첫번째 원소 넣고
				while(!deque.isEmpty()) {
					sb.append(",").append(deque.pollFirst());// , 다음 원소.
					//이렇게 하면 마지막 원소는 ,없이 끝낼 수 있음 !!!!
				}
			}
			else {
				sb.append(deque.pollLast());//맨 뒤 원소 넣고
				while(!deque.isEmpty()) {
					sb.append(",").append(deque.pollLast());// , 다음 원소.
				}
			}
			
		}
		
		sb.append("]").append("\n");
		return;
		
	}

}
