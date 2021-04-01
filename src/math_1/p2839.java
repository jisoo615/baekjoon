package math_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2839 {
//설탕 3kg 5kg 짜리가 있다. 딱 맞춰서 들고 갈 수 업으면 -1 출력.
	public static void main(String[] args) {
		//n = 3*x + 5*y
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int x, y;
			int N = Integer.parseInt(br.readLine());
			if(N>=5) {
					if(N%5==0) {x=0; y=N/5;	
								bw.write(String.valueOf(x+y));}//5로 나눠떨어질때
					else { x=0; y=N/5;
						while(y>=0) {
							if((N-5*y)%3==0) { x=(N-5*y)/3; bw.write(String.valueOf(x+y));break;}
							else y -=1;//3으로 안나눠떨어지면 y를 1줄여서 다시 3으로 나눠보게 함.
							
							if (y==-1) {bw.write(String.valueOf(-1)); break;}//y=0, 즉 3만으로도 안 나눠떨어지면 
																	//여기서 y는 -1이된다.-> -1출력, 그리고 break;
						}
					}
			}
			 /*n이 5미만일떈 n=3아니면 다 -1출력임*/
			else if(N==3) {x=1; y=0; bw.write(String.valueOf(x+y));}
			else bw.write(String.valueOf(-1));
			
			bw.flush();
		}catch(Exception e) { e.printStackTrace();	}
		
		
	}

}
