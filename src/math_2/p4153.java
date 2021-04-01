package math_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p4153 {
//세 변을 입력받고, 직각삼각형 이면 right 아니면 wrong
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
		while(true) {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		if(a==0 && b==0 && c==0) break; // 0 0 0 입력되면 종료
		
		int temp;
		if(a>c) {temp=c; c=a; a=temp;}
		temp=c;
		if(b>c) {temp=c; c=b; b=temp;}
		//c가 젤 큰 수로 만들기.
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
