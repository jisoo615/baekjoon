package twoPointer;

import java.util.ArrayList;
import java.util.Scanner;

//소수의 합
/*
 *런타임 에러나는 이유 테스트케이스가 n=1인 경우도 고려해야됨. 
 */
public class p1644 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int start=0, end=0, cnt=0;
		int sum = 0;
		if(n>1) {
			
			ArrayList<Integer> list= getPrimes(n);
			
			while(true) {
				
				if(sum < n) {
					if(end==list.size()) break;
					sum += list.get(end);
					end ++;
				}
				else {//sum >= n
					if(sum==n) cnt++;
					sum -= list.get(start);
					start ++;//맨 앞꺼 빼주기
					if(start==list.size()) break;
				}
				
				
			}
		}
		System.out.print(cnt);
		sc.close();
	}
	
	static ArrayList<Integer> getPrimes(int n){
		ArrayList<Integer> list = new ArrayList<>();
		boolean[] arr = new boolean[n+1];
		//소수가 아닌 것을 true로
		for(int i=2; i<=Math.sqrt(n)+1; i++) {//2~제곱근까지의 숫자를 돌림
			if(arr[i]==true) continue;
			for(int j= i*i; j<=n; j+=i) {//2~제곱근까지의 소수들의 '제곱수~배수들만' 처리
				arr[j] = true;
			}
		}
		//소수인 false를 리스트에 넣음
		for(int i=2; i<=n; i++) {
			if(arr[i]==false) list.add(i);
		}
		
		return list;
	}

}