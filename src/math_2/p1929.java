package math_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1929 {
//M이상 N이하 사이 소수 모두 구하기
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			if(M==1) M+=1;//1은 검사못하게,, 소수가 아니라서 
				for(int i=M; i<=N; i++) {
					boolean prime = true;
					for(int p=2; p<=Math.sqrt(i); p++) {
						if(i%p==0) {prime=false; break;}
					}
					if(prime) bw.write(i+"\n");
				}
			bw.flush();			
		}catch (Exception e) {e.printStackTrace();}

	}

}
