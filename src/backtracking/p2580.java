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
		
		if(row==9) {//�� ä�������� ����ϰ� ������
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(arr[i][j]+" ");
				}sb.append("\n");
			}System.out.print(sb);  //�Ʒ��� �ٷ� �����ϱ� ������ main���� ����� �� ���� ���⼭ ����ؾ� ��
		//����� �ý��� ����, ����Ǽ� �Ѱ��� ����϶�� �߱� ����. ������ϸ� �������� ��µ� �� ����
		System.exit(0);
		}
		
		if(arr[row][col]==0) {//������ ���������
			for(int i=1; i<=9; i++) {//1~9�߿� ������ ���ڰ� ���� ã�´�.
				if(posibility(row, col, i)) {//�˻��ϰ� �����ϸ� ���ڳִ´�.
					arr[row][col]=i;//���� ���� ä���
					sudoku(row, col+1);//��������
				}
		}
			//���̻� ä��� ���� ��(�߸�ä�������)�� ��͸� �ٽ� �������;� �ϴµ� ���� ä���� ������ �ȵż� 0���� �������´�.
			arr[row][col]=0;
			return;
		}
		sudoku(row, col+1);//���� �Ⱥ�������� �������� �Ѿ
	}
//-------------------------------------------------------------------------------------------------------
	public static boolean posibility(int row, int col, int value) {
		for(int i=0; i<9; i++) {
			if(arr[row][i]==value){//���ο� �ִ���
				return false;
			}
		}
		for(int i=0; i<9; i++) {
			if(arr[i][col]==value){//���ο� �ִ���
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
