package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17298_array {
// i번째 오른쪽에 있는 수중 큰 수들 중에 가장 왼쪽에 있는 수를 구해라. 없으면 -1
// 인덱스를 스택에 쌓아서 하는 방식.
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		int[] stack = new int[N];
		int top = -1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			while(top != -1 && seq[stack[top]] < seq[i]) {
				seq[stack[top]] = seq[i];
				top--;
			}
			top++;
			stack[top] =i;
		}
		
		
		System.out.print(sb);
	}

}
