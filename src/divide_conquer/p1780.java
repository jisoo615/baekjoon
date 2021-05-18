package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1780 {
	public static int[][] board;
	public static int minusOne=0;
	public static int zero=0;
	public static int one=0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 끝
		
		partition(0, 0, N);
		
		System.out.print(minusOne+"\n"+zero+"\n"+one);

	}
	
	public static void partition(int x, int y, int size) {
		if(isSame(x, y, size)) {
			
			if(board[x][y]==-1) {
				minusOne++;
			}
			else if(board[x][y]==0) {
				zero++;
			}
			else {
				one++;
			}
			
			return;
		}
		
		int newsize = size / 3;
		
		partition(x, y, newsize);
		partition(x, y+newsize, newsize);
		partition(x, y+(newsize*2), newsize);
		
		partition(x+newsize, y, newsize);
		partition(x+newsize, y+newsize, newsize);
		partition(x+newsize, y+(newsize*2), newsize);
		
		partition(x+(newsize*2), y, newsize);
		partition(x+(newsize*2), y+newsize, newsize);
		partition(x+(newsize*2), y+(newsize*2), newsize);
		
	}
	
	public static boolean isSame(int x, int y, int size){
		int number = board[x][y];
		
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				
				if(number != board[i][j]) {//board는 i, j이어야 함. !!<xy가 아님>
					return false;
				}
			}
		}
		
		return true;
	}

}
