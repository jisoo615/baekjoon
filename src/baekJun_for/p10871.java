package baekJun_for;

import java.util.Scanner;

public class p10871 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder result = new StringBuilder();
		int size = sc.nextInt();
		int x = sc.nextInt();
		
		int arr[] = new int[size];
		
		for(int i=0; i<size; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i =0; i<size; i++) {
			if(arr[i]<x) result.append(arr[i]+" ");
		}
		System.out.print(result);
		sc.close();
	}

}
