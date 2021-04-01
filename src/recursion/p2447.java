package recursion;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//���� �ʹ� ��ƴ�
public class p2447 {
/*�����  �Է� n�� 3�� �ŵ������̴�. n = 3^k
 ***
 * * 
 ***
 */	static char[][] array;
	public static void main(String args[]) throws IOException{
	 Scanner sc = new Scanner(System.in);
	 int N = sc.nextInt();
	 array = new char[N][N];
	 for(int i=0; i<N; i++) {
		 Arrays.fill(array[i], ' ');
	 }
	 makeStar(0, 0, N);
	 for(int i=0; i<N; i++) {
		 System.out.println(array[i]);
	 }
	 
	 sc.close();
 }
	
	static void makeStar(int x, int y, int num) {
		if(num==1) {
			array[x][y] = '*';
			return;
		}
		int val = num/3;
		for(int a=0; a<3; a++) {
			for(int b=0; b<3; b++) {
				if(a==1 && b==1) continue;
				else makeStar(x+a*val, y+b*val, val);
			}
		}
	}
}
