package baekJun_for;

import java.util.Scanner;

public class p1330 { //���ؿ� ���� �� ���� ������ ����� Ŭ���� �̸��� 'Main'�̿��� ��. �׷��� ���� �ȳ�:

	public static void main(String[] args) {
		System.out.print("�� ���� �Է��ϼ��� : ");
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();
		Compare c = new Compare(A,B);
		System.out.println(c.flag);
		
		
		String flag;
		if (A>B) flag= ">";
		else if (A<B) flag="<";
		else flag="==";
		System.out.println(flag);
		

	}
}