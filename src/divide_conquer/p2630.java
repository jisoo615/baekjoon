package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2630 {
	public static int[][] board;
	public static int white=0;
	public static int blue=0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}//�Է� ��
		
		partition(0, 0, N);
		
		System.out.print(white+"\n"+blue);

	}
	
	public static void partition(int row, int col, int size) {//�� �� ũ��
		if(colorCheck(row, col, size)) {//��Ƽ�� �� �÷��� �� ���� ���
			if(board[row][col] == 0) {
				white++;
			}else {
				blue++;
			}
			return;
		}
		
		int newsize = size / 2;
		partition(row, col, newsize);//1��и�
		partition(row, col + newsize, newsize);//2��и�
		partition(row + newsize, col, newsize);//3��и�
		partition(row + newsize, col + newsize, newsize);//4��и�
		
	}
	
	//���� ��Ƽ�� �÷��� �� ������ �˻�
	public static boolean colorCheck(int row, int col, int size) {
		int color = board[row][col];
		
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				
				if(board[i][j] != color) {
					return false;
				}
			}
		}
		
		return true;
	}

}
