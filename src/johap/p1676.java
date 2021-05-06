package johap;

import java.util.Scanner;

public class p1676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt =0;
		//어떤 수를 소인수 분해해서 보면 2*5가 있는 개수만큼 0이 있다. 
		//항상 2가 더 많이 나오기 때문에 5의 개수만큼 0의 개수가 정해진다고 할 수 있다. 
		while(N>=5) {
			cnt += N/5;
			N = N/5;
		}
		
		System.out.print(cnt);

	}

}
