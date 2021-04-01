package recursion;

import java.util.Scanner;

public class p11729_hanoi {
//�ϳ���ž.
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
			
	//start �̵��Ϸ��� ������ ����ġ, mid ���İ��� ��, to�� ���������� �Ű����� �ϴ� ��
		hanoi(n-1, start, to, mid);//n-1���� A���� B�� �̵� A:����� C:��ġ�°� B:������
		sb.append(start+" "+to+"\n");//n+1��°�� A���� C�� �̵� 
		hanoi(n-1, mid, start, to);//n-1���� 2������ 3������ �̵� B a C
	}
}
