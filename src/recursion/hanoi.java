package recursion;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//하노이탑 연습
public class hanoi {
public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		move(n, 1, 2, 3);
		
		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			bw.write(String.valueOf(sb));
		}catch (Exception e) {e.printStackTrace();};
		
		sc.close();
	}
//ABC로 표현하니까 더 이해가 잘간다.
	public static void move(int n, int A, int B, int C) {//A자리는 현재 자리from, B자리는 통과하는 자리via, C자리는 최종도착 자리to
		if(n==1) {
			sb.append(A+"->"+C+"\n");
			return;//리턴 빼먹으면 안됨!!!
		}
		move(n-1, A, C, B);//1. n개를 A->B로 옮기기
		sb.append(A+"->"+C+"\n");//2. n+1번쨰를 A->C로 옮기기
		move(n-1, B, A, C);//3. n개를 B->C로 옮기기
	}
}
