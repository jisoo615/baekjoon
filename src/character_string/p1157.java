package character_string;

import java.util.Scanner;

public class p1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine().toUpperCase();
		int[] check = new int[26];
		
		for(int i=0; i<word.length(); i++) {
			check[word.charAt(i)-65] += 1;
		}
																																																														
		int many =0; 
		char result = ' ';
		for(int j=0; j<26; j++) {
			if(many<check[j])	{
					many = check[j];
					result = (char)(j+65);
				}
			else if(many !=0 && check[j] == many) result = '?';
			}
		System.out.print(result);
sc.close();
	}
}
