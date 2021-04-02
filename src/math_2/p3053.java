package math_2;

import java.util.Scanner;

public class p3053 {
//택시기하학
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		System.out.println(String.format("%.6f", Math.pow(x, 2)*Math.PI));//유클리드 기하학 r^2*PI
		System.out.println(String.format("%.6f", Math.pow(x, 2)*2));//택시 기하학 2*(r^2)
sc.close();
	}

}
