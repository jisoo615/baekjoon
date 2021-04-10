package backtracking;

import java.util.Scanner;

public class p9663 {
	public static int count;
	public static int[] arr;
	public static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[N];
		nQueen(0);
		System.out.print(count);
sc.close();
	}
	
	public static void nQueen(int depth) {
		if(depth==N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			arr[depth] = i;
			if(posibility(depth)) {
				nQueen(depth+1);
			}
		}
	}
	
	public static boolean posibility(int col) {
		
		for(int i=0; i<col; i++) {
			if(arr[col]==arr[i]) {
			return false;
			}
			else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])){
			return false;
			}
		}
		return true;
	}

}
