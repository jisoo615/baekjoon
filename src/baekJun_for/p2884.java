package baekJun_for;

import java.util.Scanner;

public class p2884 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		if(M<45) {
			M=M-45+60;
			
			if(H==0) {
			H=H-1+24;
			}else H-=1;
		}else M-=45;
		
		System.out.print(H+" "+M);
		
		sc.close();
	}
}
