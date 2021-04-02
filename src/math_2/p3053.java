package math_2;

import java.util.Scanner;

public class p3053 {
//택시기하학
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		System.out.println(String.format("%.6f", Math.pow(x, 2)*Math.PI));//유클리드 기하학 r^2*PI
		System.out.println(String.format("%.6f", Math.pow(x, 2)*2));//택시 기하학 2*(r^2) : 2.000000
sc.close();
		//Math.round로 해보기
	System.out.println(Math.round(Math.pow(x, 2)*Math.PI*1000000)/1000000.0);// 3.141593
	System.out.println(Math.round(Math.pow(x, 2)*2*1000000)/1000000.0);// 2.0
	}

}
