package math_1;

import java.util.Scanner;

public class p2292 {
//벌집 1+1 ~ 1+1*6  / 7+1 ~ 7+2*6  / first(=start+1) ~ start+x*6 
	//중요: 답은 x+1해줘야됨. x는 지나간 문의 갯수, x+1은 지나간 방의 갯수(문제는 방의 갯수를 세는 것이다.)
	//13->2개의 문을 지나고 3개의 방을 지난다. 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x =1, start=1;
		int answer = 0;
		while(true) {
			if(n==1) {answer=1; break;}
			if(start+1<= n && n<=start+x*6) { 
				answer =x+1; 
				break;
			}
			start = start+x*6;
			x = x+1;
		}
		System.out.print(answer);
		sc.close();
	}

}
