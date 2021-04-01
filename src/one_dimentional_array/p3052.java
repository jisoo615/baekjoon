package one_dimentional_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p3052 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] numbers = new int[10];
		int[] result = new int[42];
		try {
			for(int i=0; i<10; i++) {
				numbers[i] = Integer.parseInt(br.readLine());
				int remainder = numbers[i]%42;
				result[remainder] +=1; //0~41까지가 42로 나눈 나머지가 될 수 있다.
		}
			int sum =0;
			for(int i=0; i<42; i++) {
				if( result[i]>0 ) sum+=1;
				else continue;
			}
			bw.write(sum+"\n"); // \n줄바꿈 문자 넣어줘야 안꺠져서 출력됨... 왜지?
			bw.flush();
		}catch(Exception e) { System.out.println(e);  }
		
	}

}
