package math_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p1712 {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));)
	{
			String[] s = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			int C = Integer.parseInt(s[2]);
			int i=0;	//(c-b)*i>A일떄 손익분기점을 넘는다. /*C>B로 1씩 증가해서 풀면 런타임 에러남*/
			if(B<C) {//가격보다 원가가 더 비싸면 어찌되든 손익분기점 넘을 수 없다.그래서 원가보다 높을때만 계산한다.
				while(true) {
					if((C-B)*i>A) { System.out.println(i);  
									//두번째 방법:  i = A/(C-B)를 올림한 값.
										double result = A/(C-B);
										System.out.println((int)(Math.floor(result)+1));
									break; 
					}
						i++;
				}
			}
			else {System.out.println(-1);}	
		}catch(Exception e) {e.printStackTrace();}
		}
}
