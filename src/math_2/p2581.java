package math_2;

import java.util.ArrayList;
import java.util.Scanner;
//arrayList�� �ѹ� �����غô�. �Ҽ��� ���ϴ� ����� p1978 ����� ����.
public class p2581 {//�Ҽ�
	//���θ޼ҵ�
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M=sc.nextInt();
		int N=sc.nextInt();
		ArrayList<Integer> primeNumber = new ArrayList<>();
		
		for(int k=M; k<=N; k++) {
			if(isPrime(k)) primeNumber.add(k); 
		}
		if(!primeNumber.isEmpty()) {//�Ҽ��� �����ϴ� ��쿡��
			int mini = primeNumber.get(0);
			int sum = mini;
			for(int k=1; k<primeNumber.size(); k++) {
				sum += primeNumber.get(k);
			}
		
			System.out.print(sum+"\n"+mini);
			}
		else System.out.print(-1);
		sc.close();
		}
	//�޼ҵ�
	public static boolean isPrime(int x) {
			if(x==1) return false; 
			for(int i=2; i<=Math.sqrt(x); i++) {
				if(x%i==0) return false;
			}
			return true;
	}
	
}
