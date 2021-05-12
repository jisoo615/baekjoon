package queue_deque;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		while(q.size() > 1) {// poll이 두번이지만 offer한번 해서 
			q.poll();		//1씩 줄어들기 때문에 while문 안에 break 넣어줄 필요 없음
			int item = q.poll();
			q.offer(item);
		}
		
		System.out.println(q.poll());
		
		
		//array로 풀어보기
		int[] arr = new int[N*2];//삭제하지 않고 계속 뒤에 추가하는데 인덱스를 움직일 거임
		for(int i=1; i<=N; i++) {
			arr[i] = i;//인덱스 0은 안씀
		}
		int prev_indx = 1;
		int last_indx = N;
		
		while(N-- > 1) {// '1' 2 3 4 5 '6'
			prev_indx += 1;//처음꺼 버림 1 '2' 3 4 5 '6'
			
			last_indx +=1;
			arr[last_indx] = arr[prev_indx];//맨 위에꺼를 맨 뒤로 추가함. 1 '2' 3 4 5 6 '2'
			prev_indx +=1;	// 1 2 '3' 4 5 6 '2'
		}
		
		System.out.print(arr[prev_indx]);
		
		sc.close();

	}

}
