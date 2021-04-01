package baekJun_for;

import java.util.Scanner;

public class p8393 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		for(int i=1; i<=num; i++) {
			sum += i;
		}
System.out.print(sum);
sc.close();
	}
}
