package johap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//��Ŭ���� ȣ����
public class p2609 {
//�ִ����� �ּҰ���� ���ϱ�
	//���
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		if(A<B) {
			int tmp = A;
			A = B;
			B = tmp;
		}
		
		//�ִ�����(GCD) Greatest Common Divisor ���ϱ� ��Ŭ���� ȣ����
		int gcd = GCD(A, B);
		System.out.println(gcd);
		System.out.print(A*B / gcd); //�ּҰ���� = A*B/�ִ�����
		
	}
	
	public static int GCD(int a, int b) {
		if(b==0) {
			return a;
		}
		return GCD(b, a%b);
	}

}
