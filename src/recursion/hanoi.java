package recursion;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//�ϳ���ž ����
public class hanoi {
public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		move(n, 1, 2, 3);
		
		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			bw.write(String.valueOf(sb));
		}catch (Exception e) {e.printStackTrace();};
		
		sc.close();
	}
//ABC�� ǥ���ϴϱ� �� ���ذ� �߰���.
	public static void move(int n, int A, int B, int C) {//A�ڸ��� ���� �ڸ�from, B�ڸ��� ����ϴ� �ڸ�via, C�ڸ��� �������� �ڸ�to
		if(n==1) {
			sb.append(A+"->"+C+"\n");
			return;//���� �������� �ȵ�!!!
		}
		move(n-1, A, C, B);//1. n���� A->B�� �ű��
		sb.append(A+"->"+C+"\n");//2. n+1������ A->C�� �ű��
		move(n-1, B, A, C);//3. n���� B->C�� �ű��
	}
}
