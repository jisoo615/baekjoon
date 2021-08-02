package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1300 {
//long Ÿ������ �ް� �������� Ʋ���� ����.
	//����: N�� 10^5�� ����, K�� min( n^9, N^2)�� ����
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Integer.parseInt(br.readLine());//N*Nũ���� �迭�ּ� (arr[i][j]=i*j)
		long K = Integer.parseInt(br.readLine());//K��° �� ����? => "���Ϸ��� value���� ���ų� ���� ���� k-1�� �ִ�"�� Ǯ���
		
		long start = 1; long end = N*N; long mid=0;
		long KthValue=0; 
		while(start <= end) {
			mid = (start+end)/2;
			
			long sameORunder=0;
			for(int i=1; i<N+1; i++) {//���� �� �������� �ε����� 1���� ������.
				sameORunder += Math.min(mid/i, N);// mid/i���� n�� �� �� ���� �� = mid���� �۰ų� ���� ���� ����.
			}
			
			if(sameORunder >= K) {//k�� �̻��϶�
				KthValue = mid;
				end = mid-1;
			}
			else {//k�� �̸��϶�
				start = mid+1;
			}
		}
		
		System.out.print(KthValue);
		

	}

}
