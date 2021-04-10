package backtracking;

import java.util.Scanner;

public class p9663_1 {
	public static int N;
	public static int[] arr;
	public static int count;	
	//������ �ϳ��� ü���� �Ѱ��� ���� �� ����
	//�׷��� depth�� ���̰� arr[depth]���� ������ ���� ���̴�. 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		//arr[������]�� ü������ �ִ� ���� ������ ����. 
		nQueen(0);
		System.out.print(count);
		
		sc.close();
	}
	
	public static void nQueen(int depth) {
		if(depth==N) {//N���� ü���ǿ� ������ ��츸 count (�� depth�� ���� ���� ������)
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			arr[depth] = i;// i�� �� _ arr[depth(=��)][i(=��)] �� ���̴�.
			if(posibility(depth)) {//�ش� ������ i��° �࿡ ���� �� �ִ��� �˻�./
				nQueen(depth+1);
			}
		}
	}
	
	public static boolean posibility(int col) {
		for(int i=0; i<col; i++) {
			if(arr[col]==arr[i]) {//���� ��(value)(������)�� �ִ��� �˻�
				return false;
			}
			//�밢���� �ִ��� �˻� :���� ���� ���� ���� ������ �밢���� �ִ� ���̴�.
			else if(Math.abs(col-i)==Math.abs(arr[col]-arr[i])){
				 return false;
			}
		}
		return true;
	}

}
