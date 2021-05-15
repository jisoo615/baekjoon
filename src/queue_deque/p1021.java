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
			}// 1~N까지 있는 덱
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<M; i++) {
				seq[i] = Integer.parseInt(st.nextToken());
			}//뽑으려는 수
			
			int count =0;
			for(int i=0; i<M; i++) {
				int target_indx = dq.indexOf(seq[i]);
				int half_indx;//중간지점 인덱스
				if(dq.size() %2 == 0) {//dq의 인덱스는 0부터 시작임을 생각해야함. 
					half_indx = dq.size() / 2 -1;// 1~8 이면 중앙값은4. 인덱스는 3
				}else {//길이가 홀수면
					half_indx = dq.size() / 2; // 1~7 이면 중앙값은4, 인덱스는 3
				}
				
				//2, 3번 연산
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
