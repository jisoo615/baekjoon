package one_dimentional_array;

import java.util.Scanner;

public class p8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());//nextLine�� �� intŸ������ �ٲ��༭ �Ʒ� ������ ��~
		//String throwEnter = sc.nextLine(); //nextInt�߱� ������ �ڿ� ���Ͱ� ���Ƽ� ���� ���� ���͸� �����ؼ� ������ ��.
		
		for(int i=0; i<num; i++) {
			String answer = sc.nextLine();
			int score = 0; 
			int count = 0;
			for(int j=0; j<answer.length(); j++) {
				if(answer.charAt(j)=='O') count+=1; //O�� ū����ǥ �ȵ�! ' '�� �ؾ� charŸ��..
				else { 	count = 0; }
				score += count; //�������� ������� ������ �������� ���̱� ������ ��� ������ߵ�.
			}
			System.out.println(score);
		}
sc.close();
	}

}
