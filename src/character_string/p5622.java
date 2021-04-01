package character_string;

import java.util.Scanner;

public class p5622 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int time = 0;
		for(int i=0; i<s.length(); i++) {
			int number = s.charAt(i);
			if(number>=65 && number<=67) time += 3;
			else if(number>=68 && number<=70) time +=4;
			else if(number>=71 && number<=73) time +=5;
			else if(number>=74 && number<=76) time +=6;
			else if(number>=77 && number<=79) time +=7;
			else if(number>=80 && number<=83) time +=8;
			else if(number>=84 && number<=86) time +=9;
			else if(number>=87 && number<=90) time +=10;
		}
		System.out.print(time);
		
sc.close();
	}

}
