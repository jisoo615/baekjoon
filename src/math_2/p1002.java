package math_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1002 {
//터렛
	public static void main(String[] args) {
		//입력 : x1, y1, r1, x2, y2, r2
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int d = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);//sqrt쓰면 실수 오차있을 가능성 있어서 답이 틀릴수 있음
			int r = (r1+r2)*(r1+r2);				//정수형으로 비교해보기. 제곱한 상태로
			int subR= (r1-r2)*(r1-r2);//두 반지름의 차이 의 제곱
			
			if(d==0) {//거리가 0일 때
				if(r1==r2) bw.write("-1\n");//완전 겹치는 원
				else bw.write("0\n");
			}
			else {//거리가 0이상일 때
				if(r==d || subR==d) bw.write("1\n");//외접 || 내접
				else if(r>d && subR<d) bw.write("2\n"); //* r1+r2>d && r1-r2<d : 내접하는 경우 초과 ~ 외접하는 경우 미만
				else bw.write("0\n");
			}
				
			}
			br.close();bw.close();
		}catch (Exception e) {e.printStackTrace();}

	}

}
