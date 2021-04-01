package baekJun_for;

import java.util.Scanner;

public class p2753 {//윤연이면 1 아니면 0

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		int answer;
		if(year%4==0) {
			if(year%100==0) {
				if(year%400==0) answer=1;
				else answer = 0;
			}
			else answer = 1;
		}
		else answer = 0;
		
		System.out.print(answer);
		sc.close();

	}

}
