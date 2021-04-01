package one_dimentional_array;

import java.util.Scanner;

public class p10818 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr[] = new int[size];
		for(int i=0; i<size; i++) {
			arr[i] = sc.nextInt();
		}
		int max=arr[0];
		int mini=arr[0];
		for(int j=0; j<size; j++) {
			if(max<arr[j]) max=arr[j];
			else if(mini>arr[j]) mini=arr[j];
		}
		System.out.println(mini+" "+max);
		sc.close();
	}

}
