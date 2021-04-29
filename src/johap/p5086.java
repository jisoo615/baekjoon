package johap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class p5086 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			if(first==0 && second==0) break;
			
			
			//
			if(first<second && second%first==0) {
				sb.append("factor\n");
			}
			else if(first>second && first%second==0) {
				sb.append("multiple\n");
			}
			else sb.append("neither\n");
		}
		
		System.out.print(sb);

	}

}
