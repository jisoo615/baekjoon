package character_string;

import java.util.Scanner;

public class p11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = Integer.parseInt(sc.nextLine());
		//double y = Double.parseDouble(sc.nextLine());//256�̻��� ���ڴ� int�� ǥ�� �Ұ�����->double//double�� �ص� 25�ڸ��� ����
		String[] s = sc.nextLine().split("");
		
		int sum = 0;
		for(int i=0; i<x; i++) {
			int y = Integer.parseInt(s[i]);
			int num = y%10;
			y = y/10;
			
			sum += num;
		}
		System.out.print(sum);
sc.close();
	}

}
