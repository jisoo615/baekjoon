package johap;

import java.util.Scanner;

public class p1676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt =0;
		//� ���� ���μ� �����ؼ� ���� 2*5�� �ִ� ������ŭ 0�� �ִ�. 
		//�׻� 2�� �� ���� ������ ������ 5�� ������ŭ 0�� ������ �������ٰ� �� �� �ִ�. 
		while(N>=5) {
			cnt += N/5;
			N = N/5;
		}
		
		System.out.print(cnt);

	}

}
