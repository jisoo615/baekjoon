package baekJun_for;

import java.util.Scanner;

public class p1330 { //백준에 제출 할 때는 무조건 실행될 클래스 이름이 'Main'이여야 함. 그래야 에러 안남:

	public static void main(String[] args) {
		System.out.print("두 수를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();
		Compare c = new Compare(A,B);
		System.out.println(c.flag);
		
		
		String flag;
		if (A>B) flag= ">";
		else if (A<B) flag="<";
		else flag="==";
		System.out.println(flag);
		

	}
}