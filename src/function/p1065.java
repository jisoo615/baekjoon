package function;

import java.util.Scanner;
//�Ѽ�:� ���� x�� �� �ڸ� ���� ���������� �̷�� �� �ΰ�. 123 157
//�� �ڸ� �� �Ʒ�(100)�̸��� ��� �� �Ѽ���. (��Ȯ���� 99��)
//�� �ڸ� �� �ϋ��� ����ؾ� �Ѵ�. (���⼭ �Է��� 1000���� �۰ų� ���� �� �϶� ��)
public class p1065 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(numberOfHansu(n));
		
sc.close();
	}
	
	public static int numberOfHansu(int x) {
		int number=0;
		if(x>=100) {
			number += 99;
			for(int i=100; i<=x; i++) {
				int y = i;
				
				int first = y%10;
				y = y/10;
				int second = y%10;
				y = y/10;
				int third = y%10;

				if((second-first)==(third-second)) number +=1;
				
			}
		}
		else number = x;
		if(x==1000) number -=1;//1000�� ��� 4�ڸ� ���� 000�񱳰� ������ ����� -1�� ����� �Ѵ�.
		return number;
	}
}
