package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1417 {
//�������� ��Ÿ�� ����...
	public static void main(String[] args) {
		try(	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			String number = br.readLine();
			int n = Integer.parseInt(number);
			int[] cnt = new int[10]; //0~9�������� ī��Ʈ
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<number.length(); i++) {
				cnt[n%10] += 1;
				n = n/10;
			}//�� �ڸ� ���� �迭�� �־���
			
			for(int i=0; i<10; i++) {
				if(cnt[i]>0) {
					for(int j=0; j<cnt[i]; j++) {
						sb.append(i);
					}
				}else continue;
			}
			bw.write(String.valueOf(sb));
			bw.flush();
			
		}catch (Exception e) {e.printStackTrace();}

	}

}
