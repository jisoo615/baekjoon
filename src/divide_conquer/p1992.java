package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//참고한 블로그 : https://st-lab.tistory.com/230
public class p1992 {
	public static int[][] board;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				board[i][j] = s.charAt(j) - '0';//이러면 '0'(아스키코드81)은 81-81=0, '1'(아스키코드82)은 82-81=1이 저장됨. 
			}
		}//입력 끝
		
		QuadTree(0, 0, N);
		
		System.out.print(sb);

	}
	
	public static void QuadTree(int x, int y, int size) {
		if(isSame(x, y, size)) {//해당 파티션 내 숫자가 모두 같으면
			
			sb.append(board[x][y]);
			return;//꼭 리턴 해줘야됨 !!!!
		}
		
		int newsize = size / 2;
		
		sb.append("(");
		
		QuadTree(x, y, newsize);
		QuadTree(x, y + newsize, newsize);
		QuadTree(x + newsize, y, newsize);
		QuadTree(x + newsize, y + newsize, newsize);
		
		sb.append(")");
	}
	
	public static boolean isSame(int row, int col, int size) {
		int number = board[row][col];
		
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				
				if(board[i][j] != number) {
					return false;
				}
			}
		}
		return true;
	}

}
