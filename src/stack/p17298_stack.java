package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p17298_stack {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<N; i++) {
			while(!stack.empty() && seq[stack.peek()] < seq[i]) {// 스택이 쌓여있고, 스택맨위 < 현재수 이면 팝하면서 현재수로 바꿔줌.
				seq[stack.pop()] = seq[i];
			}
			stack.push(i); //비어있으면 무조건 현재 수 push, 스택맨위 > 현재수 즉 큰 수를 찾을 때까지 push함
		}
		
		while(!stack.empty()) {
			seq[stack.pop()] = -1;//위에서 다 끝나고 남아있는 스택을 팝하면서 -1로 업데이트해줌
		}
		
		for(int val : seq) {
			sb.append(val).append(" ");
		}
		
		System.out.print(sb);

	}

}
