package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1541 {
//������ �ٲ��� �ʰ� ��ȣ�� �߰��� �׷��ֱ⸸ �ϴ� ����.
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		String[] splitBySub = br.readLine().split("-"); 
		
		for(int i=0; i<splitBySub.length; i++) {
			int temp =0;
															//StringTokenizer �� �׳� "+" �ص� ��.
			String[] splitByAdd = splitBySub[i].split("\\+"); //�����ϰ� ���� �� ��ü�� �̿��ϱ� ���ؼ��� �̽������� ó���� �ؾ� +�� �и���
			for(int j=0; j<splitByAdd.length; j++) {
				temp += Integer.parseInt(splitByAdd[j]);
			}
			
			if(i == 0) {
				sum += temp;
			}else {
				sum -= temp;
			}
		}
		
		System.out.print(sum);

	}

}
