package math_2;

import java.util.Scanner;

public class p1978 {
//소수찾기
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count =0;
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			boolean isPrime =true;//prime number: 소수
			if(num==1) {isPrime = false;}
			else {
				for(int k=2; k<=Math.sqrt(num); k++) {
					if(num%k==0) {isPrime=false; break;}
					else isPrime = true;
				}
			}
			if(isPrime) count+=1;
		}
		System.out.print(count);
		sc.close();
	}
}
