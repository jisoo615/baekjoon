package twoPointer;

import java.util.ArrayList;
import java.util.Scanner;

//�Ҽ��� ��
/*
 *��Ÿ�� �������� ���� �׽�Ʈ���̽��� n=1�� ��쵵 ����ؾߵ�. 
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
					start ++;//�� �ղ� ���ֱ�
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
		//�Ҽ��� �ƴ� ���� true��
		for(int i=2; i<=Math.sqrt(n)+1; i++) {//2~�����ٱ����� ���ڸ� ����
			if(arr[i]==true) continue;
			for(int j= i*i; j<=n; j+=i) {//2~�����ٱ����� �Ҽ����� '������~����鸸' ó��
				arr[j] = true;
			}
		}
		//�Ҽ��� false�� ����Ʈ�� ����
		for(int i=2; i<=n; i++) {
			if(arr[i]==false) list.add(i);
		}
		
		return list;
	}

}