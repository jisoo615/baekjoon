package character_string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p2675_tokenizer {//이게 더빠름(128ms) 왜냐, 출력까지 buffered를 썼으니까(스트링 빌더는 bw로 못 출력해서 println으로했기 때문)

			public static void main(String[] args) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
			try {
				int x = Integer.parseInt(br.readLine());
				
				for(int i=0; i<x; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine(), " "); //케이스 갯수
					int y = Integer.parseInt(st.nextToken());
					String test = st.nextToken();
					
						for(int k=0; k<test.length(); k++) {//문자열 인덱스
							for(int j=0; j<y; j++) { //반복은 여기서
								bw.write(test.charAt(k));
							}
						}
						bw.write("\n");
				}
				bw.flush();
			}catch(Exception e) {}
				
			}
	}