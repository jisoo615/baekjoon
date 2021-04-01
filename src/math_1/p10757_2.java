package math_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;
//BigInteger ¿Í add»ç¿ë
public class p10757_2 {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			bw.write(String.valueOf(new BigInteger(st.nextToken()).add(new BigInteger(st.nextToken()))));
			bw.flush();
			
		}catch (Exception e) {e.printStackTrace();}

	}

}
