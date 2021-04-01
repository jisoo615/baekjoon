package baekJun_for;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p15552 { //p11021, p11022

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {	
			int number = Integer.parseInt(br.readLine());
			for(int i=0; i<number; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				bw.write("Case #"+(i+1)+": "+a+" + "+b+" = "+(a+b)+"\n");	
			}
			bw.flush();
	}catch (Exception e) {}

	
	}
}
