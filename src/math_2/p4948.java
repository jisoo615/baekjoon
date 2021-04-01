package math_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p4948 {
//����Ʈ�� ���� : n�� 2n ���̿�(n���� ũ�� 2n���� �۰ų� ����)�� ��� 1���� �Ҽ��� �����Ѵٴ� �� �����.
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			while(true) {
				int n = Integer.parseInt(br.readLine());
				if(n==0) break;//0�� �ԷµǸ� �Է��� �ߴ�.
				
				int count =0;
				for(int i=n+1; i<=2*n; i++) {
					boolean prime=true;
					for(int k=2; k<=Math.sqrt(i); k++) {//�ٻ񰪺��� �۰ų� ��.��.��. ��!!! 
						if(i%k==0) {
							prime = false;
							break;
						}
					}
					if(prime) count+=1; //�Ҽ��� ���� ī��Ʈ
				}
			bw.write(String.valueOf(count)+"\n");
			bw.flush();
			}
		}catch (Exception e) {e.printStackTrace();}

	}

}
