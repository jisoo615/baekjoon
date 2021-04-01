package baekJun_while;

import java.util.Scanner;

public class p10951 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			System.out.println(x+y);
		}
		sc.close();
	}

}
