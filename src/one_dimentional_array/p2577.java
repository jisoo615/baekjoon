package one_dimentional_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2577 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] numbers = new int [3];
		try {
		for(int i=0; i<3; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		int abc = numbers[0]*numbers[1]*numbers[2];
		int[] result = new int [10];
		while(true) {
			int num = abc%10;
			result[num] +=1;
			abc = (abc-num)/10;
			if(abc==0) break;
		}
		for(int x : result) bw.write(x+"\n");
		bw.flush();
		}catch (Exception e) { }
	}

}
