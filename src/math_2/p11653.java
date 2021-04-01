package math_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p11653 {
//소인수분해
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
		int x = Integer.parseInt(br.readLine());
			for(int i=2; i<=Math.sqrt(x); i++) {
					while(x%i==0) { 
						x=x/i; 
						bw.write(String.valueOf(i)+"\n"); 
						}
			}
		//아래 코드 한줄을 추가한 이유는 입력받은 숫자 자체가 소수일 경우를 대비한 것이다. 
		if(x!=1) bw.write(String.valueOf(x)+"\n");
			bw.flush();
		}catch(Exception e){e.printStackTrace();}
		}
}
