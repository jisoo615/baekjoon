package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1427 {
//소트인사이드
	public static void main(String[] args) {
		try(
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int[] cnt = new int[10];//아스키코드 60~71 -> 문자 0~9
			String s = br.readLine();
			for(int i=0; i<s.length(); i++) {
				cnt[s.charAt(i)-48] +=1;
			}
			for(int j=9; j>=0; j--){
				for(int k=0; k<cnt[j]; k++) {
					bw.write(String.valueOf(j));
				}
				
			}bw.flush();
			
		}catch(Exception e) {e.printStackTrace();}

	}

}
