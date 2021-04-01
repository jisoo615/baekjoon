package character_string;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;

public class p2675 {//140ms나옴

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //스트링빌더는 이걸로 출력못하나봄..
		
	try {
		int x = Integer.parseInt(br.readLine());
		
		for(int i=0; i<x; i++) {
			String test = br.readLine();
			StringBuilder sb = new StringBuilder();
			
			int y = Integer.parseInt(test.split(" ")[0]); //반복횟수
				for(int k=0; k<test.split(" ")[1].length(); k++) {//문자열 인덱스
					for(int j=0; j<y; j++) { //반복은 여기서
						sb.append(test.split(" ")[1].charAt(k));
					}
				}
				System.out.println(sb);
		}
	}catch(Exception e) {}
		
	}

}
