package one_dimentional_array;

import java.util.Scanner;

public class p8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());//nextLine한 후 int타입으로 바꿔줘서 아래 지워도 됨~
		//String throwEnter = sc.nextLine(); //nextInt했기 때문에 뒤에 엔터가 남아서 다음 줄은 엔터를 리턴해서 버리는 용.
		
		for(int i=0; i<num; i++) {
			String answer = sc.nextLine();
			int score = 0; 
			int count = 0;
			for(int j=0; j<answer.length(); j++) {
				if(answer.charAt(j)=='O') count+=1; //O에 큰따음표 안됨! ' '로 해야 char타입..
				else { 	count = 0; }
				score += count; //연속으로 맞출수록 점수가 높아지는 것이기 때문에 계속 더해줘야됨.
			}
			System.out.println(score);
		}
sc.close();
	}

}
