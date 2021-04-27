package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1541_Tokenizer {
//토크나이저로 해보기
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = Integer.MAX_VALUE;
		StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-"); 
		
		while(subtraction.hasMoreTokens()) {
			int temp =0;
															//StringTokenizer 는 그냥 "+" 해도 됨.
			StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+"); 
			while(addition.hasMoreTokens()) {
				temp += Integer.parseInt(addition.nextToken());
			}
			
			if(sum == Integer.MAX_VALUE) { //맨 첫번째수는 음수가 되지 않도록 먼저 더해주고 시작(양수와 - + 만 가지고 식 세운 거니까)
				sum = temp;
			}else {
				sum -= temp;
			}
		}
		
		System.out.print(sum);	
	}

}
