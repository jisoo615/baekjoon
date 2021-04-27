package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1541 {
//순서는 바꾸지 않고 괄호를 추가고 그려넣기만 하는 문제.
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		String[] splitBySub = br.readLine().split("-"); 
		
		for(int i=0; i<splitBySub.length; i++) {
			int temp =0;
															//StringTokenizer 는 그냥 "+" 해도 됨.
			String[] splitByAdd = splitBySub[i].split("\\+"); //온전하게 문자 그 자체로 이용하기 위해서는 이스케이프 처리를 해야 +로 분리됨
			for(int j=0; j<splitByAdd.length; j++) {
				temp += Integer.parseInt(splitByAdd[j]);
			}
			
			if(i == 0) {
				sum += temp;
			}else {
				sum -= temp;
			}
		}
		
		System.out.print(sum);

	}

}
