package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p10989 {
//�̸� 10000�ڸ��� ����� ���� �� �ڸ��� 1�� �������ش�.
	public static void main(String[] args) {
		try(	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int[] arr = new int[10000];
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; i++) {
				arr[Integer.parseInt(br.readLine())-1] +=1; //1���� 10000������ ����(�迭�� 0~9999)
			}
			int count =0; 
			for(int j=0; j<10000; j++) {
				if(arr[j] != 0) {
					for(int k=0; k<arr[j]; k++) {	
						bw.write(String.valueOf(j+1)+"\n");	
						count++;
					}
				}
				if(count>n) break;
			}bw.flush();
			
		}catch (Exception e) { e.printStackTrace();	}
	}

}
