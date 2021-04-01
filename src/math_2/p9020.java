package math_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p9020 {
//골드바흐의 추측 : 2보다 큰 짝수는 두 소수의 합으로 나타냏 수 있다. 
//x의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; i++) {
				int x = Integer.parseInt(br.readLine());
				for(int k=x/2; k>=2; k--){//x의 절반부터 내려가면서 검사
					if(isPrime(k)) {
						if(isPrime(x-k)) { 
							bw.write(String.valueOf(k)+" "+String.valueOf(x-k)+"\n");
							break;
						}else continue;
					}else continue;			
				}
			}
			bw.flush();
		}catch(Exception e) {e.printStackTrace();}

	}
	public static boolean isPrime(int number) {
			for(int i=2; i<=Math.sqrt(number); i++) {//근삿값보다 같.거.나. 작게!!!
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}

}
