package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2580 {
	public static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9][9];
		StringTokenizer st;
		
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sudoku(0, 0);		
	}
//-------------------------------------------------------------------------------------------------------
	public static void sudoku(int row, int col) {
		if(col==9) {
			sudoku(row+1, 0);
			return;
		}
		
		if(row==9) {//다 채워졌으면 출력하고 끝내기
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(arr[i][j]+" ");
				}sb.append("\n");
			}System.out.print(sb);  //아래서 바로 종료하기 때문에 main에서 출력할 수 없어 여기서 출력해야 함
		//출력후 시스템 종료, 경우의수 한개만 출력하라고 했기 때문. 종료안하면 여러개가 출력될 수 있음
		System.exit(0);
		}
		
		if(arr[row][col]==0) {//스도쿠가 비어있으면
			for(int i=1; i<=9; i++) {//1~9중에 가능한 숫자가 뭔지 찾는다.
				if(posibility(row, col, i)) {//검사하고 가능하면 숫자넣는다.
					arr[row][col]=i;//값을 먼저 채우고
					sudoku(row, col+1);//다음으로
				}
		}
			//더이상 채울수 없을 때(잘못채워진경우)는 재귀를 다시 빠져나와야 하는데 값이 채워져 있으면 안돼서 0으로 돌려놓는다.
			arr[row][col]=0;
			return;
		}
		sudoku(row, col+1);//값이 안비어있으면 다음으로 넘어감
	}
//-------------------------------------------------------------------------------------------------------
	public static boolean posibility(int row, int col, int value) {
		for(int i=0; i<9; i++) {
			if(arr[row][i]==value){//가로에 있는지
				return false;
			}
		}
		for(int i=0; i<9; i++) {
			if(arr[i][col]==value){//세로에 있는지
				return false;
			}
		}
		int rowStart=row/3*3; int colStart=col/3*3;
		for(int i=rowStart; i<rowStart+3; i++) {
			for(int j=colStart; j<colStart+3; j++) {
				if(arr[i][j]==value) {
					return false;
				}
			}
		}
		
		return true;
	}

}
