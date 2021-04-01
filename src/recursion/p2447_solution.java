package recursion;
import java.io.*;
import java.util.*;
public class p2447_solution {
	static char[][] array;//�������� 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		array = new char[N][N];
		for(int a=0;a<N;a++) {
			Arrays.fill(array[a],' '); //���پ� ��� ����ó��
		}
		star(0,0,N);//�Լ� ����
		for(int a=0;a<N;a++) {
			System.out.println(array[a]);//�迭�� ��� ���
		}
		br.close();
	}

	static void star(int x, int y, int num) { //���� ��� �Լ�
		if(num==1) {
			array[x][y]='*'; //���̻� ���� �� ���� ���϶� ���ڸ��� *�� �ִ´�.
			return;
		}
		int s = num/3;
		for(int a=0;a<3;a++) {
			for(int b=0;b<3;b++) {
				if(a == 1 && b == 1) {
					continue; // �ٷ� ���� �ݺ������� �ѱ�� ���� Ű����
				}
				System.out.println("star("+(x+s*a)+", "+(y+s*b)+", "+s+")");
				star(x+s*a,y+s*b, s);
			}
		}
	}
}