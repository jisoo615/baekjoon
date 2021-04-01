package character_string;

import java.util.Scanner;

public class p10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[] result = new int[26];
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<26; i++) {
			result[i] = -1;
		}
		
		for(int i=0; i<s.length(); i++) {
			if(result[s.charAt(i)-97]==-1)	result[s.charAt(i)-97] = i;
			//해당 알파벳이 첫번째로 나오는 것만 기록해야 돼서
		}
		
		for(int i=0; i<26; i++) {
			sb.append(result[i]+" ");
		}
		System.out.print(sb);
		sc.close();
	}

}
