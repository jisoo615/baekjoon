package math_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p1712 {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));)
	{
			String[] s = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			int C = Integer.parseInt(s[2]);
			int i=0;	//(c-b)*i>A�ϋ� ���ͺб����� �Ѵ´�. /*C>B�� 1�� �����ؼ� Ǯ�� ��Ÿ�� ������*/
			if(B<C) {//���ݺ��� ������ �� ��θ� ����ǵ� ���ͺб��� ���� �� ����.�׷��� �������� �������� ����Ѵ�.
				while(true) {
					if((C-B)*i>A) { System.out.println(i);  
									//�ι�° ���:  i = A/(C-B)�� �ø��� ��.
										double result = A/(C-B);
										System.out.println((int)(Math.floor(result)+1));
									break; 
					}
						i++;
				}
			}
			else {System.out.println(-1);}	
		}catch(Exception e) {e.printStackTrace();}
		}
}
