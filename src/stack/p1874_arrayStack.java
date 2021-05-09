package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1874_arrayStack {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		int indx=0;
		int num =0;
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x > num){
				for(int j=num+1; j<=x; j++) {
					arr[indx] = j;
					indx++;
					sb.append("+").append("\n");
			}
				num = x;
			}
			
			else if(arr[indx-1] != x) { //peek()은 스택이 비었을때 호출하면 예외발생
				System.out.print("NO");//수열 출력만들수 없으면 no출력
				System.exit(0);//종료
			}
			
			//pop()
			indx--;
			sb.append("-").append("\n");
		}
		
		System.out.print(sb);

	}

}
