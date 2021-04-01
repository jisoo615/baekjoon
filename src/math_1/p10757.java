package math_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//런타임 에러->p10757_2에선 BigInteger 와 .add()사용 
public class p10757 {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String x = st.nextToken(); String y = st.nextToken();
			
			if(x.length()<y.length()) { String temp = x;
										x = y;
			/*더 긴(큰)수를 x로 바꾸기*/		y=temp; 
			}//else { 	}
			int[] answer = new int[x.length()];
			//1의 자리가 인덱스0부터 오게 저장
			int ten=0; //ten: 더해서 올릴 10의자리 숫자
			for(int i=0; i<x.length(); i++) {//A랑 B릃 더하기 1의자리숫자부터(x,y끝에서부터 앞으로)
				int sum=0;
				//문자 0의 아스키 코드값은 48임으로, -48을 하면 본래 숫자의 값을 알 수 있다.
				if(i<y.length()) sum = ten+x.charAt(x.length()-1-i)-48+y.charAt(x.length()-1-i)-48;
				else sum = ten +x.charAt(x.length()-1-i)-48;
				
				if(sum>=10) { ten = (sum)/10;}	
				else ten = 0;
				answer[i]= sum%10;
			}
			
			StringBuilder sb = new StringBuilder();
			if(ten>0) sb.append(ten); //위 루프에서 젤 높은 자리에서 ten이 있다면 먼저 출력
			for(int i=answer.length-1; i>=0; i--) {
				sb.append(answer[i]);
			}
			bw.write(String.valueOf(sb));
			bw.flush();
			
		}catch (Exception e) {e.printStackTrace();}

	}

}
