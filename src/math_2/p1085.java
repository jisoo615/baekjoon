package math_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1085 {
//���簢�� (0, 0) (w, h)  �� ��ġ(x,y) ���� ���簢���� ������ ���� �ּұ��̴�? 
//�Է�: x y w h
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			int result1 = w-x < h-y ? w-x : h-y; //���� �� ������ ��
			int result2 = x < y ? x:y; //x,y�� ���簢���� ���� ���Ͽ� ������.
			int answer = result1 < result2 ? result1 : result2;
			
			bw.write(String.valueOf(answer));
			bw.flush();
		}catch(Exception e) {e.printStackTrace();}

	}

}
