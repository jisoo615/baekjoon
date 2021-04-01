package sort;

import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.InputStreamReader; 
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class p2750{ 
	static public void main(String[] args){
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); ){
		int n = Integer.parseInt(br.readLine()); 
		int[] list = new int[n];
		for(int i=0; i<n; i++){ 
			list[i] = Integer.parseInt(br.readLine());
			} 
		Arrays.sort(list);
		
		for(int i=0; i<n; i++) {
			bw.write(String.valueOf(list[i])+"\n"); 
		}
		bw.flush();
		}catch (Exception e) {e.printStackTrace();}
		} 
	}