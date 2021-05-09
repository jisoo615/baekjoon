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
			
			else if(st.peek() !=x) { //peek()은 스택이 비었을때 호출하면 예외발생
				System.out.print("NO");//수열 출력만들수 없으면 no출력
				System.exit(0);//종료
			}
			
			st.pop();//ex) 4까지 추가했으면 4pop할 차례고, 4보다 큰수 아닌 이상 계속 pop하면 됨.
			sb.append("-").append("\n");
		}
		
		System.out.print(sb);

	}

}
