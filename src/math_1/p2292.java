package math_1;

import java.util.Scanner;

public class p2292 {
//���� 1+1 ~ 1+1*6  / 7+1 ~ 7+2*6  / first(=start+1) ~ start+x*6 
	//�߿�: ���� x+1����ߵ�. x�� ������ ���� ����, x+1�� ������ ���� ����(������ ���� ������ ���� ���̴�.)
	//13->2���� ���� ������ 3���� ���� ������. 
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
