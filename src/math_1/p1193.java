package math_1;

import java.util.Scanner;

public class p1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int a=0, b=0;   /* 2/4 = a/b */
		int i=1;
		while(x>0) {//�� ��ƾ�� 1�� �����ϴ� n���� ��
			for(int j=0; j<i; j++) {
				a = i-j; /**/ b = j+1;
				x--;
				if(x==0) break;
			}if(x==0) break;//�� break�� for�� break�� while���� break�ؾ� ��������.
			i++;
			for(int k=0; k<i; k++) {
				a=k+1; /**/ b=i-k;
				x--;
				if(x==0) break;
			}if(x==0) break;//�� break�� for�� break�� while���� break�ؾ� ��������.
			i++;
		}
		System.out.print(a+"/"+b);
		
sc.close();
	}

}
