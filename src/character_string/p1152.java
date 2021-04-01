package character_string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1152 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		bw.write(st.countTokens()+"\n");
		bw.flush();
		}catch (Exception e) { e.printStackTrace();}
	}

}
