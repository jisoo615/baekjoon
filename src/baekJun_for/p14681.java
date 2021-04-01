package baekJun_for;

import java.util.Scanner;

public class p14681 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int quadrant;
		if (x>0 && y>0) quadrant = 1;
		else if (x>0 && y<0) quadrant = 4;
		else if (x<0 && y>0) quadrant = 2;
		else quadrant = 3;
		
		System.out.print(quadrant);
		sc.close();
	}

}
