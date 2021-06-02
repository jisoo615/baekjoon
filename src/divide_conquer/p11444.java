package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11444 {
	public static long[][] origin = {{1,1},{1,0}};
	public static long[][] result;
	static final long MOD = 1000000007;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		
		result = pow(origin, N);
		
		System.out.print(result[0][1]);

	}
	
	public static long[][] pow(long[][] arr, long expo) {
		if(expo==0 || expo == 1) {
			return arr;
		}
		
		long[][] ret = pow(arr, expo/2);
		ret = multiply(ret, ret);
		
		if(expo%2 ==1) {
			return multiply(ret, origin);
		}
		
		return ret;
	}
	
	public static long[][] multiply(long[][] o1, long[][] o2){
		long[][] ret = new long[2][2];
		
		ret[0][0] = (o1[0][0]*o2[0][0] + o1[0][1]*o2[1][0])%MOD;
		ret[1][0] = (o1[1][0]*o2[0][0] + o1[1][1]*o2[1][0])%MOD;
		ret[0][1] = (o1[0][0]*o2[0][1] + o1[0][1]*o2[1][1])%MOD;
		ret[1][1] = (o1[1][0]*o2[0][1] + o1[1][1]*o2[1][1])%MOD;
		
		return ret;
		
	}
	

}
