package one_dimentional_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p4344 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
	try {
		int c = Integer.parseInt(br.readLine());
		String[] cases = new String[c]; //���̽� �� �� �� ��
		
		for(int i=0; i<c; i++) {
			cases[i] = br.readLine();
			String[] temp = cases[i].split(" "); //�߶� �迭�� ��� �־���� ���ڷ� �ٲ� ���
			double sum = 0;
			double number = Double.parseDouble(temp[0]);
			for(int j=1; j<number+1; j++) { //ù��°�� ���� �� �̱� ������ �����+1�ؾ� ���̽� ��ü �迭 ũ����.
				sum += Double.parseDouble(temp[j]);
			}
			double average = sum/number;
	
			//��� �Ѵ� �л��� ���� ���ϱ�. �Ҽ��� 3° �ڸ�����
			int count = 0; 
			for(int j=1; j<number+1; j++) {
				if(Integer.parseInt(temp[j])>average) count+=1;
			}
			
			bw.write(String.format("%.3f", (count/number*100))+"%\n");
			bw.flush();
			}
		
		}catch (Exception e) { System.out.println(e); }
	}
	}
