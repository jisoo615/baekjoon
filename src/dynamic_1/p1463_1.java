package dynamic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1463_1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.print(recur(N, 0));
	}
	
	public static int recur(int n, int cnt){
		if(n<2) {//2이하일때로 해야됨
			return cnt;
		}
		return Math.min(recur(n/2, cnt+1+(n%2)), recur(n/3, cnt+1+(n%3)));
	}

}
