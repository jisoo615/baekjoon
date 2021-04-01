package math_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p3009 {
//세 점을 입력받고 축에 대칭되는 점을 출력해라
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int Ax = Integer.parseInt(st.nextToken()); int Ay = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int Bx = Integer.parseInt(st.nextToken()); int By = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int Cx = Integer.parseInt(st.nextToken()); int Cy = Integer.parseInt(st.nextToken());
		//점 세개 입력받음
	//x중에 같은 것이 없는 것, y중에 같은 값이 없는 것이 Dx, Dy다.
		int Dx, Dy;
			if(Ax==Bx) { Dx=Cx; }
			else if(Ax==Cx) { Dx=Bx; }
			else Dx=Ax;
			
			if(Ay==By) { Dy=Cy; }
			else if(Ay==Cy) { Dy=By; }
			else Dy=Ay;
			
			bw.write(Dx+" "+Dy+"\n");
		}catch(Exception e) {e.printStackTrace();}

	}

}
