package queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p11866_list {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());		
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int index = 0;
		
		while(N>1) {
			index = (index+(K-1)) % N;//이게 핵심. 삭제할 인덱스를 구함
			sb.append(list.remove(index)).append(", ");
			N -= 1;
		}
		
		sb.append(list.remove(0)).append(">");
		System.out.print(sb);
	}

}
