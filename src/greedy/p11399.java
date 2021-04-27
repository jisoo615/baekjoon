package greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//ATM arrays.sort로 풀기
public class p11399 {
//젤 오래걸리는 사람이 맨 마지막에 하면 최소 시간 나옴. a a+b a+b+c a+b+c+d 이런 식이니까 젤 큰 수가 d가 되면 됨
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] time = new int[N];
		for(int i=0; i<N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		//정렬
		Arrays.sort(time);
		
		int wait = 0;
		int sum = 0;
		for(int i=0; i<N; i++) {
			wait += time[i];
			sum += wait;
		}
		
		System.out.print(sum);

	}

}
