package math_1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1712_2 {
	

		public static void main(String[] args) {
			try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
		{
				String[] s = br.readLine().split(" ");
				int A = Integer.parseInt(s[0]);
				int B = Integer.parseInt(s[1]);
				int C = Integer.parseInt(s[2]);
				if(B<C) {//���ݺ��� ������ �� ��θ� ����ǵ� ���ͺб��� ���� �� ����.�׷��� �������� �������� ����Ѵ�.
										//�ι�° ���:  result = A/(C-B)�� �ø��� ��.
											double result = A/(C-B);
											bw.write(String.valueOf((int)(Math.floor(result)+1)));
				}
				else {bw.write(String.valueOf(-1));}	
	            bw.flush();
			}catch(Exception e) {e.printStackTrace();}
			}
	}
