package one_dimentional_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p4344 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
	try {
		int c = Integer.parseInt(br.readLine());
		String[] cases = new String[c]; //케이스 한 줄 한 줄
		
		for(int i=0; i<c; i++) {
			cases[i] = br.readLine();
			String[] temp = cases[i].split(" "); //잘라서 배열에 잠시 넣어놓고 숫자로 바꿔 계산
			double sum = 0;
			double number = Double.parseDouble(temp[0]);
			for(int j=1; j<number+1; j++) { //첫번째는 과목 수 이기 때문에 과목수+1해야 케이스 전체 배열 크기임.
				sum += Double.parseDouble(temp[j]);
			}
			double average = sum/number;
	
			//평균 넘는 학생들 비율 구하기. 소숫점 3째 자리까지
			int count = 0; 
			for(int j=1; j<number+1; j++) {
				if(Integer.parseInt(temp[j])>average) count+=1;
			}
			
			bw.write(String.format("%.3f", (count/number*100))+"%\n");
			bw.flush();
			}
		
		}catch (Exception e) { System.out.println(e); }
	}
	}
