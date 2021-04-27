package greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//ATM arrays.sort�� Ǯ��
public class p11399 {
//�� �����ɸ��� ����� �� �������� �ϸ� �ּ� �ð� ����. a a+b a+b+c a+b+c+d �̷� ���̴ϱ� �� ū ���� d�� �Ǹ� ��
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] time = new int[N];
		for(int i=0; i<N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		//����
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
