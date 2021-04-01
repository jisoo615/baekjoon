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
			bw.write(String.valueOf(s.length())); //bw.write쓰기는 문자 출력이니까 바꿔서.. 아니면 +"\n"하거나
			bw.flush();
			bw.close();
			br.close();
		}catch(Exception e) {e.printStackTrace();}
	}
}
