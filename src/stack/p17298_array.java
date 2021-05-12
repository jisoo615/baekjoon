package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17298_array {
// i��° �����ʿ� �ִ� ���� ū ���� �߿� ���� ���ʿ� �ִ� ���� ���ض�. ������ -1
// �ε����� ���ÿ� �׾Ƽ� �ϴ� ���.
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		int[] stack = new int[N];
		int top = -1;//������ ������� -1��.
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			while(top != -1 && seq[stack[top]] < seq[i]) {
				seq[stack[top]] = seq[i];//pop�ϸ鼭 �� �ٲ��ֱ�
				top--;
			}
			top++;
			stack[top] =i;//push
		}
		
		for(int i= top; i>=0; i--) {
			seq[stack[i]] = -1;//���ÿ� �����ִ� �͵帪�� -1�� update
		}
		
		for(int val : seq) {
			sb.append(val).append(" ");
		}
		
		System.out.print(sb);
	}

}
