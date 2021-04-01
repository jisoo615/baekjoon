package math_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1085 {
//직사각형 (0, 0) (w, h)  내 위치(x,y) 에서 직사각형의 경계까지 가는 최소길이는? 
//입력: x y w h
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			int result1 = w-x < h-y ? w-x : h-y; //차가 더 적은게 답
			int result2 = x < y ? x:y; //x,y가 직사각형의 절반 이하에 있을때.
			int answer = result1 < result2 ? result1 : result2;
			
			bw.write(String.valueOf(answer));
			bw.flush();
		}catch(Exception e) {e.printStackTrace();}

	}

}
