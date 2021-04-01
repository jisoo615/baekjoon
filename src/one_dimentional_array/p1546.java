package one_dimentional_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1546 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
		int num = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		int[] score = new int[num];
		
		for(int i=0; i<num; i++) {
			score[i] = Integer.parseInt(temp[i]);
		}
		double max =score[0];
		for(int i=0; i<num; i++) {
			if(score[i]>max)	max = score[i];
		}
		double newSum = 0;
		for(int i=0; i<num; i++) {
			newSum += ((double)score[i])/max*100;
		}
		bw.write(newSum/num+"\n");
		bw.flush();
		}catch (Exception e){ System.out.println(e); }
	}

}
