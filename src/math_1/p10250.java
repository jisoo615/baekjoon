package math_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/* 1. if N > H*W �϶� N = N % ( H*W )
   2. else N<=H*W �϶�
*/
public class p10250 {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			
		int num = Integer.parseInt(br.readLine());
		int H=0, W=0, N=0; //����, ����, ���° �մ�
		for(int i=0; i<num; i++) {
			String[] s = br.readLine().split(" ");
			H = Integer.parseInt(s[0]);
			W = Integer.parseInt(s[1]);
			N = Integer.parseInt(s[2]);
			
			if(N>H*W) N = N%(H*W);
			//else
			int floor = N % H;
			int door = N/H;
			
			if(floor==0) bw.write(String.valueOf(H));
			else bw.write(String.valueOf(floor));
			
			if(N%H/*n%h=���floor*/!=0) door = door+1;
			//else 
			if(door<10) bw.write("0"); 
			bw.write(String.valueOf(door)+"\n");
		}			
		}catch (Exception e) {e.printStackTrace();}
		
		}

}
