package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class p1427_1 {

	public static void main(String[] args) {
		try(	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			String s = br.readLine();
			int[] arr = new int[s.length()];
			for(int i=0; i<s.length(); i++) {
				arr[i]=s.charAt(i)-48;
			}
			Arrays.sort(arr);
			for(int i=s.length()-1; i>=0; i--) {
				bw.write(String.valueOf(arr[i]));
			}bw.flush();
		}catch(Exception e) {e.printStackTrace();}

	}

}
