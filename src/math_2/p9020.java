package math_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p9020 {
//�������� ���� : 2���� ū ¦���� �� �Ҽ��� ������ ��Ÿ�Y �� �ִ�. 
//x�� ������ ��Ƽ���� ���� ������ ��쿡�� �� �Ҽ��� ���̰� ���� ���� ���� ���
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; i++) {
				int x = Integer.parseInt(br.readLine());
				for(int k=x/2; k>=2; k--){//x�� ���ݺ��� �������鼭 �˻�
					if(isPrime(k)) {
						if(isPrime(x-k)) { 
							bw.write(String.valueOf(k)+" "+String.valueOf(x-k)+"\n");
							break;
						}else continue;
					}else continue;			
				}
			}
			bw.flush();
		}catch(Exception e) {e.printStackTrace();}

	}
	public static boolean isPrime(int number) {
			for(int i=2; i<=Math.sqrt(number); i++) {//�ٻ񰪺��� ��.��.��. �۰�!!!
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}

}
