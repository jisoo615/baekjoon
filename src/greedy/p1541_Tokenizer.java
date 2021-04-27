package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1541_Tokenizer {
//��ũ�������� �غ���
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = Integer.MAX_VALUE;
		StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-"); 
		
		while(subtraction.hasMoreTokens()) {
			int temp =0;
															//StringTokenizer �� �׳� "+" �ص� ��.
			StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+"); 
			while(addition.hasMoreTokens()) {
				temp += Integer.parseInt(addition.nextToken());
			}
			
			if(sum == Integer.MAX_VALUE) { //�� ù��°���� ������ ���� �ʵ��� ���� �����ְ� ����(����� - + �� ������ �� ���� �Ŵϱ�)
				sum = temp;
			}else {
				sum -= temp;
			}
		}
		
		System.out.print(sum);	
	}

}
