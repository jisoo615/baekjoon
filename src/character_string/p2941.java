package character_string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2941 {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			String s = br.readLine();
			String[] arr = {"c=", "c-","dz=","d-","lj","nj","s=","z="};
			for(int i=0; i<arr.length; i++) {
				s=s.replace(arr[i], "*");
			}
			bw.write(String.valueOf(s.length())); //bw.write����� ���� ����̴ϱ� �ٲ㼭.. �ƴϸ� +"\n"�ϰų�
			bw.flush();
			bw.close();
			br.close();
		}catch(Exception e) {e.printStackTrace();}
	}
}
