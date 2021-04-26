package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//그리디 알고리즘 동전0 : 최소 동전으로 K원 맞추기
public class p11047 {
	
	static int[] coin;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		coin = new int[N];
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int count=0; 
		for(int i=N-1; i>=0; i--) {
			if(coin[i] <= K) {
				count += K/coin[i];
				K = K%coin[i];
			}
		}
		
		System.out.print(count);
		
	}
}
