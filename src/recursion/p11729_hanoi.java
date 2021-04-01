package recursion;

import java.util.Scanner;

public class p11729_hanoi {
//하노이탑.
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sb.append(Math.pow(2,n)-1+"\n");
		hanoi(n, 1, 2, 3);
		System.out.print(sb);

	}

	public static void hanoi(int n, int start, int mid, int to) {
		if(n==1) {
			sb.append(start+" "+to+"\n");
			return;
		}
			
	//start 이동하려는 원판의 현위치, mid 거쳐가는 곳, to는 최종적으로 옮겨져야 하는 곳
		hanoi(n-1, start, to, mid);//n-1개를 A에서 B로 이동 A:출발지 C:거치는곳 B:도착지
		sb.append(start+" "+to+"\n");//n+1번째를 A에서 C로 이동 
		hanoi(n-1, mid, start, to);//n-1개를 2번에서 3번으로 이동 B a C
	}
}
