package math_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p3009 {
//�� ���� �Է¹ް� �࿡ ��Ī�Ǵ� ���� ����ض�
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int Ax = Integer.parseInt(st.nextToken()); int Ay = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int Bx = Integer.parseInt(st.nextToken()); int By = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int Cx = Integer.parseInt(st.nextToken()); int Cy = Integer.parseInt(st.nextToken());
		//�� ���� �Է¹���
	//x�߿� ���� ���� ���� ��, y�߿� ���� ���� ���� ���� Dx, Dy��.
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
