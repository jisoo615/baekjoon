package math_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2839 {
//���� 3kg 5kg ¥���� �ִ�. �� ���缭 ��� �� �� ������ -1 ���.
	public static void main(String[] args) {
		//n = 3*x + 5*y
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int x, y;
			int N = Integer.parseInt(br.readLine());
			if(N>=5) {
					if(N%5==0) {x=0; y=N/5;	
								bw.write(String.valueOf(x+y));}//5�� ������������
					else { x=0; y=N/5;
						while(y>=0) {
							if((N-5*y)%3==0) { x=(N-5*y)/3; bw.write(String.valueOf(x+y));break;}
							else y -=1;//3���� �ȳ����������� y�� 1�ٿ��� �ٽ� 3���� �������� ��.
							
							if (y==-1) {bw.write(String.valueOf(-1)); break;}//y=0, �� 3�����ε� �� ������������ 
																	//���⼭ y�� -1�̵ȴ�.-> -1���, �׸��� break;
						}
					}
			}
			 /*n�� 5�̸��ϋ� n=3�ƴϸ� �� -1�����*/
			else if(N==3) {x=1; y=0; bw.write(String.valueOf(x+y));}
			else bw.write(String.valueOf(-1));
			
			bw.flush();
		}catch(Exception e) { e.printStackTrace();	}
		
		
	}

}
