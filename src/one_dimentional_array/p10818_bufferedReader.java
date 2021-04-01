package one_dimentional_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p10818_bufferedReader {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//scanner ���� bufferedReader����ϴ� �� �� ����.
		//�׸��� Integer.parseInt(numbers.split(" "))�� ȿ���� ���� �ʾƼ� String[] temp�� �����ٰ� 
		//�ٽ� arr[i]�� Integer.parseInt(temp[i])�� ����
		try{
			int size = Integer.parseInt(br.readLine());
			String numbers = br.readLine();
		
			int arr[] = new int[size];
			String[] temp = numbers.split(" ");
			for(int i=0; i<size; i++) {
				arr[i] = Integer.parseInt(temp[i]);
			}
			int max=arr[0];
			int mini=arr[0];
		
			for(int i=0; i<size; i++) {
				if(max<arr[i]) max=arr[i];
				else if(mini>arr[i]) mini=arr[i];
			}
			bw.write(mini+" "+max);
			bw.flush();
		}catch (Exception e) { }
	}

}
