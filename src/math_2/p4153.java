package math_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p4153 {
//�� ���� �Է¹ް�, �����ﰢ�� �̸� right �ƴϸ� wrong
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
		while(true) {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		if(a==0 && b==0 && c==0) break; // 0 0 0 �ԷµǸ� ����
		
		int temp;
		if(a>c) {temp=c; c=a; a=temp;}
		temp=c;
		if(b>c) {temp=c; c=b; b=temp;}
		//c�� �� ū ���� �����.
		if(c*c==a*a+b*b) bw.write("right"+"\n");
		else bw.write("wrong"+"\n");
		}
		}catch(Exception e) {e.printStackTrace();}

	}

	public static void swap(int x, int y) {
		int temp =x;
		if(x<y) { x=y; y=temp;}
	}
}
