package math_2;

import java.util.Scanner;

public class p3053 {
//�ýñ�����
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		System.out.println(String.format("%.6f", Math.pow(x, 2)*Math.PI));//��Ŭ���� ������ r^2*PI
		System.out.println(String.format("%.6f", Math.pow(x, 2)*2));//�ý� ������ 2*(r^2)
sc.close();
	}

}
