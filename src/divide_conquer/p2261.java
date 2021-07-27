package divide_conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2261 {
	static int dots[][];
//ù° ���� ���� ����� ������ �Ÿ��� ������ ���϶�
	//����-->�ִ��Է¼��� 100000���̱� ������ O(N^2)--> ������������ �ٽ� Ǯ��
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			dots = new int[n][2];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				dots[i][0] = Integer.parseInt(st.nextToken());//x��ǥ
				dots[i][1] = Integer.parseInt(st.nextToken());//y��ǥ
			}
			
			int answer= Integer.MAX_VALUE;
			for(int i=1; i<n; i++) {
				
				answer = Math.min(answer, solveDistance(i));
			}
			
			System.out.print(answer);
			
		}catch(Exception e){e.printStackTrace();}
		

	}
	
	public static int solveDistance(int nth) {
		int xx = Math.abs(dots[0][0]-dots[nth][0]);
		int yy = Math.abs(dots[0][1]-dots[nth][1]);
		return xx*xx+yy*yy;
	}
	

}
