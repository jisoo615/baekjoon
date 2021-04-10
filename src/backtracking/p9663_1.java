package backtracking;

import java.util.Scanner;

public class p9663_1 {
	public static int N;
	public static int[] arr;
	public static int count;	
	//가로줄 하나에 체스말 한개만 있을 수 있음
	//그래서 depth가 열이고 arr[depth]값이 세로줄 행인 셈이다. 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		//arr[가로줄]에 체스말이 있는 행을 적어줄 것임. 
		nQueen(0);
		System.out.print(count);
		
		sc.close();
	}
	
	public static void nQueen(int depth) {
		if(depth==N) {//N개를 체스판에 놓았을 경우만 count (즉 depth는 현재 놓은 말갯수)
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			arr[depth] = i;// i는 행 _ arr[depth(=열)][i(=행)] 인 셈이다.
			if(posibility(depth)) {//해당 열에서 i번째 행에 놓을 수 있는지 검사./
				nQueen(depth+1);
			}
		}
	}
	
	public static boolean posibility(int col) {
		for(int i=0; i<col; i++) {
			if(arr[col]==arr[i]) {//같은 행(value)(세로줄)에 있는지 검사
				return false;
			}
			//대각선에 있는지 검사 :열의 차와 행의 차가 같으면 대각선에 있는 것이다.
			else if(Math.abs(col-i)==Math.abs(arr[col]-arr[i])){
				 return false;
			}
		}
		return true;
	}

}
