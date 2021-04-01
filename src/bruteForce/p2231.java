package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//부르트포스에 맞게 1부터 n까지 다 해보는 방법
public class p2231 {
	
	public static void main(String args[]) {
		int generator = 0;
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			if(findGenerator(i)==n) {
				generator = i;
				break;
			}
		}
		}catch (Exception e) {e.printStackTrace();}
		
		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			bw.write(generator+"\n");
			bw.flush();
		}catch (Exception e) {e.printStackTrace();}
		
	}
	
	
	public static int findGenerator(int a) { //어떤 수의 분해합을 뱉어냄. ->a가 생성자
			int original = a;
			int sum = 0;
			while(a>0){
				sum += a%10;
				a = a/10;
			}
			return original+sum;
		}
	
}
