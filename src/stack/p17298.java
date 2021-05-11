package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p17298 {
// i번째 오른쪽에 있는 수중 큰 수들 중에 가장 왼쪽에 있는 수를 구해라. 없으면 -1
	public static int N;
	public static int[] seq;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		seq = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(NGE(i)).append(" ");
		}
		
		System.out.print(sb);

	}
	
	public static int NGE(int indx) {
		Stack<Integer> stack = new Stack<>();
		for(int i=N-1; i>=indx; i--) {
			if(seq[indx-1] < seq[i]) {
				stack.add(seq[i]);
			}
		}
		if(stack.isEmpty()) {return -1;}
		else {return stack.peek();}
	}

}
