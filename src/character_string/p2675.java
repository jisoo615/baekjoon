package character_string;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;

public class p2675 {//140ms����

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //��Ʈ�������� �̰ɷ� ��¸��ϳ���..
		
	try {
		int x = Integer.parseInt(br.readLine());
		
		for(int i=0; i<x; i++) {
			String test = br.readLine();
			StringBuilder sb = new StringBuilder();
			
			int y = Integer.parseInt(test.split(" ")[0]); //�ݺ�Ƚ��
				for(int k=0; k<test.split(" ")[1].length(); k++) {//���ڿ� �ε���
					for(int j=0; j<y; j++) { //�ݺ��� ���⼭
						sb.append(test.split(" ")[1].charAt(k));
					}
				}
				System.out.println(sb);
		}
	}catch(Exception e) {}
		
	}

}
