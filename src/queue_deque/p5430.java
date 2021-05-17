package queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
//못풀어서 p5430_retry에 다시 품. AC 메소드로 헷갈리지 않게
public class p5430 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());//
		
		LinkedList<Integer> dq = new LinkedList<>();

		StringBuilder sb = new StringBuilder();
		
		while(T-- >0) {
			String command = br.readLine();//
			
			int N = Integer.parseInt(br.readLine());//
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");//
			for(int i=0; i<N; i++) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}
			
			sb.append("[");
			//RD면 pollLast하면 됨. RRD면 pollFirst하면 됨.
			boolean reversed = false;
			int countD = 0;
			for(int j=0; j<command.length()-1; j++) {
				char fx = command.charAt(j);
				if(fx=='D') {
					countD +=1;
				}
				if(countD > N) {//
					sb.append("error").append("\n");
					break;
				}
				
				switch(fx) {
				case 'R' : if(reversed) {
					reversed = false;
					}else {
					reversed = true;
					}
					break;
					
				case 'D' : 
						if(reversed) {
						sb.append(dq.pollLast());
						}else {
						sb.append(dq.pollFirst());
						}
					break;
			}
				sb.append(",");
				
			}
			sb.append(dq.poll()).append("]").append("\n");
			
		}
		System.out.print(sb);

	}

}
