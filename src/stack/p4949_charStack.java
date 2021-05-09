package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p4949_charStack {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		
		while(true) {
			s = br.readLine();
			
			if(s.equals(".")) {//문자열비교는 equals로 해야됨.
				break;
			}
			
			sb.append(solve(s)).append('\n');
		}
		System.out.print(sb);

	}
	
	public static String solve(String str) {
		char[] stack = new char[str.length()];
		int size =0;
		
		for(char c : str.toCharArray()) {
			
			if(c =='(' || c =='[') {
				stack[size]= c;
				size++;
			}
			
			else if(c ==')') {
				if(size==0 || stack[size-1] !='(') {
					return "no";
				}
				else {
					size--;
				}
			}
			
			else if(c ==']') {
				if(size==0 || stack[size-1] !='[') {
					return "no";
				}
				else {
					size--;
				}
			}
		}
		
		
		if(size!=0) {
				return "no";
			}else {
				return "yes";
			}
	}
	

}
