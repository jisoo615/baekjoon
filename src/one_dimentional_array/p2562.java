package one_dimentional_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2562 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] numbers = new int [9];
		
		try {
			for(int i=0; i<9; i++) {
				numbers[i] = Integer.parseInt(br.readLine());
			}
			int max = numbers[0];
			int max_num = 0;
			for(int i=0; i<9; i++) {
				if(numbers[i]>=max) {
					max = numbers[i];
					max_num = i+1; //배열이니까 i+1하면 해당 값 번째 수 알 수 있음
				}
			}
			bw.write(max+"\n"+max_num);
			bw.flush();
		}catch (Exception e){}
	}

}
