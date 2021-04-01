package baekJun_for;

import java.util.Scanner;

public class p10950 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		int arr[] = new int[T];
		
		for(int i=0; i<T; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			int sum = num1+num2;
			
			arr[i] = sum;
		}
		
		for(int i=0; i<T; i++) {
			System.out.println(arr[i]);
		}
		
sc.close();
	}

}
