package math_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p4948 {
//베르트랑 공준 : n과 2n 사이에(n보다 크고 2n보다 작거나 같은)는 적어도 1개의 소수가 존재한다는 것 증명됨.
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			while(true) {
				int n = Integer.parseInt(br.readLine());
				if(n==0) break;//0이 입력되면 입력을 중단.
				
				int count =0;
				for(int i=n+1; i<=2*n; i++) {
					boolean prime=true;
					for(int k=2; k<=Math.sqrt(i); k++) {//근삿값보다 작거나 같.아.야. 함!!! 
						if(i%k==0) {
							prime = false;
							break;
						}
					}
					if(prime) count+=1; //소수일 떄만 카운트
				}
			bw.write(String.valueOf(count)+"\n");
			bw.flush();
			}
		}catch (Exception e) {e.printStackTrace();}

	}

}
