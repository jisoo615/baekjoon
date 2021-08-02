package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2110 {
	public static long N;
	public static long C;
	public static long[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new long[(int)N];
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		System.out.print(binarySearch(C));
		
	}
	
	public static long binarySearch(long c) {
		long start=1; long end = arr[arr.length-1];
		long mid = 0;	int cnt = 0;
		long answer = 0;
		
		while(start <= end) {
			mid = (start+end)/2;
			
			cnt = installWifi(mid);
			
			if(cnt >= c) {//�����⸦ �ٿ����Ҷ�, �� �ÿ�����	//�� ���ǹ� ����
				start = mid+1;
				answer = mid;
			}else {//�����⸦ �� ��ġ�ؾߵɶ� �� �ٿ�����.
				end = mid-1;
			}
		}
		
		return answer;
	}
	
	public static int installWifi(long gap) {
		int indx=0;
		int cnt = 1;//�����Ⱑ arr[0]�� �ʱ⿡ ��ġ�Ǿ��ִٰ� �����ϰ�
		for(int i=1; i<N; i++) {
			if(arr[i]-arr[indx] >= gap) {//�Ÿ��� ������ ������ �� ���� ������ ��ġ
				cnt+=1;
				indx=i;//��� ��ġ�� ��� ���Ϸ���/
			}
		}
		
		return cnt;
	}

}
