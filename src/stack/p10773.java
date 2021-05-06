package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10773 {
	static int[] stack;
	static int size = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		stack = new int[N];
		
		for(int i=0; i<N; i++) {
			int number = Integer.parseInt(br.readLine());
			
			if(number == 0) {
				pop();
			}
			else {
				push(number);
			}
		}
		
		int sum=0;
		for(int n : stack) {
			sum +=n;
		}
		System.out.print(sum);

	}
	
	public static void push(int x) {
		stack[size] = x;
		size++;		
	}
	public static int pop() {
		if(size==0) {
			return -1;
		}
		else {//맨 마지막 수 0으로 초기화시킴
			int res = stack[size-1];
			stack[size-1] = 0;
			size--;
			return res;
		}
	}

}
