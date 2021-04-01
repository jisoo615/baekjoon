package baekJun_for;

import java.util.Scanner;

public class p2438 {

	public static void main(String[] args) {//º°Âï±â
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i=1; i<=n; i++) {
		StringBuilder result = new StringBuilder();
			for(int j=0; j<n-i; j++) {
				result.append(" ");
			}
			for(int k=0; k<i; k++) {
				result.append("*");
			}
		System.out.println(result);
		}
	
	for(int i=0; i<n; i++) {
		StringBuilder result = new StringBuilder();
		for(int j=0; j<i+1; j++) {
			result.append("*");
		}
		System.out.println(result);
	}
sc.close();
}}
