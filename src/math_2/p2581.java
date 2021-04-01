package math_2;

import java.util.ArrayList;
import java.util.Scanner;
//arrayList로 한번 구현해봤다. 소수를 구하는 방법은 p1978 방법과 같다.
public class p2581 {//소수
	//메인메소드
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M=sc.nextInt();
		int N=sc.nextInt();
		ArrayList<Integer> primeNumber = new ArrayList<>();
		
		for(int k=M; k<=N; k++) {
			if(isPrime(k)) primeNumber.add(k); 
		}
		if(!primeNumber.isEmpty()) {//소수가 존재하는 경우에만
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
	//메소드
	public static boolean isPrime(int x) {
			if(x==1) return false; 
			for(int i=2; i<=Math.sqrt(x); i++) {
				if(x%i==0) return false;
			}
			return true;
	}
	
}
