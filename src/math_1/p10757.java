package math_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//��Ÿ�� ����->p10757_2���� BigInteger �� .add()��� 
public class p10757 {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String x = st.nextToken(); String y = st.nextToken();
			
			if(x.length()<y.length()) { String temp = x;
										x = y;
			/*�� ��(ū)���� x�� �ٲٱ�*/		y=temp; 
			}//else { 	}
			int[] answer = new int[x.length()];
			//1�� �ڸ��� �ε���0���� ���� ����
			int ten=0; //ten: ���ؼ� �ø� 10���ڸ� ����
			for(int i=0; i<x.length(); i++) {//A�� B�f ���ϱ� 1���ڸ����ں���(x,y���������� ������)
				int sum=0;
				//���� 0�� �ƽ�Ű �ڵ尪�� 48������, -48�� �ϸ� ���� ������ ���� �� �� �ִ�.
				if(i<y.length()) sum = ten+x.charAt(x.length()-1-i)-48+y.charAt(x.length()-1-i)-48;
				else sum = ten +x.charAt(x.length()-1-i)-48;
				
				if(sum>=10) { ten = (sum)/10;}	
				else ten = 0;
				answer[i]= sum%10;
			}
			
			StringBuilder sb = new StringBuilder();
			if(ten>0) sb.append(ten); //�� �������� �� ���� �ڸ����� ten�� �ִٸ� ���� ���
			for(int i=answer.length-1; i>=0; i--) {
				sb.append(answer[i]);
			}
			bw.write(String.valueOf(sb));
			bw.flush();
			
		}catch (Exception e) {e.printStackTrace();}

	}

}
