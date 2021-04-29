package johap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1037 {
//�ּ� ����� �ִ� ����� ���ϸ� � ���� ������� �� �� ����
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			max = max < x ? x : max;
			min = min > x ? x : min;
		}
		
		System.out.print(max*min);

	}

}
