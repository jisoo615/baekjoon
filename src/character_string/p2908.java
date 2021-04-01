package character_string;

import java.util.Scanner;

public class p2908 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int A = reversing(x);
		int B = reversing(y);
		
		System.out.print(Math.max(A, B));
		
sc.close();
	}
	
	public static int reversing(int num) {
		int reversed_num = 0;
		int x = Integer.toString(num).length();
		for(int i=x-1; i>=0; i--) {
			int remain = num%10;
			reversed_num += remain*(Math.pow(10, i)); //~의 몇제곱 사용할 때는 Math.pow(밑, 지수)
			num = num/10;
		}
		return reversed_num;
	}

}
