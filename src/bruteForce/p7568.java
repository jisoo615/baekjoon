package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p7568 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		try {
		int number = Integer.parseInt(br.readLine());
		int[][] arr = new int[number][2];
		for(int i=0; i<number; i++) { //�迭�� �ְ� arr[][2]�ڸ��� ����� ���� ����--������: rank�� �ٷιٷ� ����ϱ����
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken()); 
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<number; i++) {
			int rank=1;
			for(int j=0; j<number; j++) {
				if(i==j) continue;
				if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]) rank += 1; //���� �ͺ��� ������ i�� rank�� +1�ϱ�
			}
			bw.write(rank+"\n");
		}
		bw.flush();
		}catch (Exception e) {e.printStackTrace();}
	}

}
