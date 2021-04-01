package math_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1011 {
//d거리 이동 횟수= (루트 거리)*2-1 를 올림한 값. 
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int n= Integer.parseInt(br.readLine());
			int answer;
			for(int i=0; i<n; i++) {
				String[] cases = br.readLine().split(" ");
				int x = Integer.parseInt(cases[0]);
				int y = Integer.parseInt(cases[1]);
				//
				int d = y-x;
				
				double sq = Math.sqrt((double)d);
				answer = (int)Math.ceil(sq*2-1);
				bw.write(String.valueOf(answer)+"\n");
			}
			bw.flush();
			
		}catch (Exception e) {e.printStackTrace();}

	}

}
