package math_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2869 {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
		String[] s = br.readLine().split(" ");
		int A = Integer.parseInt(s[0]);
		int B = Integer.parseInt(s[1]);
		int V = Integer.parseInt(s[2]);
		int day =0;
		V -= A;
		if(V>0) {
			if(V%(A-B)==0) { day = V/(A-B)+1; }
			else { day = V/(A-B)+2; }
			
		}else { day=1; }

		bw.write(String.valueOf(day)); bw.flush();
		}catch (Exception e) {e.printStackTrace();}
	}

}
