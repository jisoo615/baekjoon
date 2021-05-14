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
		
		
		//입력시 인덱스와 중요도 함께 저장.
		LinkedList<int[]> list;
		
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {//for로 하면 안됨..while로 해야 T-- >0 쓸 수 잇음
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());//문서 개수
			int M = Integer.parseInt(st.nextToken());//인덱스
			
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
					if(front[1] < list.get(i)[1]) {//맨 처음것 보다 크면
						list.offer(front);//먼저 poll해놓은거 offer해주고
						for(int j=0; j<i; j++) {//남은 것만큼 뒤로 보내기
							list.offer(list.poll());
						}
						
						isMax = false; //첫번째가 1순위가 아니었기에 false로 바꿔줌
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
