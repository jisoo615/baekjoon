package baekJun_while;

import java.util.Scanner;

public class p1110 {// 26->2+6=08 ->68->6+8=14 -> 84->8+4=12 ->42->4+2=06 ->26
					//�̷��� 26�� 4���� ����Ŭ �Ŀ� ���ƿ´�. ���� n�� ����Ŭ�� ���̸� ���ض�.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int check = n;
		int temp;
		int new_num;
		int circle=0;
		
		while(true) {
			temp = (n/10)+(n%10);
			new_num = (n%10)*10+(temp%10); //���� �ڸ��� ������ 10������ߵ�..
			circle++;
			n=new_num;
			if(new_num == check) break;
		}
		System.out.println(circle);
sc.close();
	}

}
