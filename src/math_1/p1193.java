package math_1;

import java.util.Scanner;

public class p1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int a=0, b=0;   /* 2/4 = a/b */
		int i=1;
		while(x>0) {//한 루틴이 1씩 증가하는 n번씩 돔
			for(int j=0; j<i; j++) {
				a = i-j; /**/ b = j+1;
				x--;
				if(x==0) break;
			}if(x==0) break;//위 break는 for문 break라서 while에도 break해야 빠져나옴.
			i++;
			for(int k=0; k<i; k++) {
				a=k+1; /**/ b=i-k;
				x--;
				if(x==0) break;
			}if(x==0) break;//위 break는 for문 break라서 while에도 break해야 빠져나옴.
			i++;
		}
		System.out.print(a+"/"+b);
		
sc.close();
	}

}
