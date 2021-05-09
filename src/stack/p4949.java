package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p4949 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		
		while(true) {
			s = br.readLine();
			
			if(s.equals(".")) {//문자열비교는 equals로 해야됨.
				break;
			}
			
			sb.append(solve(s)).append("\n");
		}
		System.out.print(sb);

	}
	
	public static String solve(String str) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(c =='(' || c =='[') {
				stack.push(c);
			}
			
			else if(c ==')') {
				if(stack.empty() || stack.peek() !='(') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
			
			else if(c ==']') {
				if(stack.empty() || stack.peek() !='[') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
		}
		
		
		if(stack.empty()) {
				return "yes";
			}else {
				return "no";
			}
	}
	

}
