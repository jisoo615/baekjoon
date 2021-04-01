package math_1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1712_2 {
	

		public static void main(String[] args) {
			try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
		{
				String[] s = br.readLine().split(" ");
				int A = Integer.parseInt(s[0]);
				int B = Integer.parseInt(s[1]);
				int C = Integer.parseInt(s[2]);
				if(B<C) {//가격보다 원가가 더 비싸면 어찌되든 손익분기점 넘을 수 없다.그래서 원가보다 높을때만 계산한다.
										//두번째 방법:  result = A/(C-B)를 올림한 값.
											double result = A/(C-B);
											bw.write(String.valueOf((int)(Math.floor(result)+1)));
				}
				else {bw.write(String.valueOf(-1));}	
	            bw.flush();
			}catch(Exception e) {e.printStackTrace();}
			}
	}
