package character_string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2908_reverse {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(new StringBuilder().append(st.nextToken()).reverse().toString());
			int y = Integer.parseInt(new StringBuilder().append(st.nextToken()).reverse().toString());
			
			System.out.print(x>y? x:y);
			
		}catch(Exception e) {	e.printStackTrace();	}
		

	}

}
