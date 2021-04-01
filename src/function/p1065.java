package function;

import java.util.Scanner;
//한수:어떤 정수 x의 각 자리 수가 등차수열을 이루는 수 인것. 123 157
//두 자릿 수 아래(100)미만은 모두 다 한수다. (정확히는 99개)
//세 자릿 수 일떄를 계산해야 한다. (여기서 입력은 1000보다 작거나 같은 수 일때 라서)
public class p1065 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(numberOfHansu(n));
		
sc.close();
	}
	
	public static int numberOfHansu(int x) {
		int number=0;
		if(x>=100) {
			number += 99;
			for(int i=100; i<=x; i++) {
				int y = i;
				
				int first = y%10;
				y = y/10;
				int second = y%10;
				y = y/10;
				int third = y%10;

				if((second-first)==(third-second)) number +=1;
				
			}
		}
		else number = x;
		if(x==1000) number -=1;//1000일 경우 4자리 수로 000비교가 됨으로 결과에 -1을 해줘야 한다.
		return number;
	}
}
