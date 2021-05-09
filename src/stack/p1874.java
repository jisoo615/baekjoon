package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1874 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int num =0;
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x > num){
				for(int j=num+1; j<=x; j++) {
					st.push(j);
					sb.append("+").append("\n");
			}
				num = x;
			}
			
			else if(st.peek() !=x) { //peek()�� ������ ������� ȣ���ϸ� ���ܹ߻�
				System.out.print("NO");//���� ��¸���� ������ no���
				System.exit(0);//����
			}
			
			st.pop();//ex) 4���� �߰������� 4pop�� ���ʰ�, 4���� ū�� �ƴ� �̻� ��� pop�ϸ� ��.
			sb.append("-").append("\n");
		}
		
		System.out.print(sb);

	}

}
