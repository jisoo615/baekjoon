package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1300 {
//long 타입으로 받고 계산해줘야 틀리지 않음.
	//범위: N은 10^5수 까지, K는 min( n^9, N^2)수 까지
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Integer.parseInt(br.readLine());//N*N크기의 배열애서 (arr[i][j]=i*j)
		long K = Integer.parseInt(br.readLine());//K번째 의 값은? => "구하려는 value보다 같거나 작은 수가 k-1개 있다"로 풀면됨
		
		long start = 1; long end = N*N; long mid=0;
		long KthValue=0; 
		while(start <= end) {
			mid = (start+end)/2;
			
			long sameORunder=0;
			for(int i=1; i<N+1; i++) {//주의 이 문제에서 인덱스는 1부터 시작함.
				sameORunder += Math.min(mid/i, N);// mid/i개와 n개 중 더 작은 게 = mid보다 작거나 같은 수의 갯수.
			}
			
			if(sameORunder >= K) {//k개 이상일때
				KthValue = mid;
				end = mid-1;
			}
			else {//k개 미만일때
				start = mid+1;
			}
		}
		
		System.out.print(KthValue);
		

	}

}
