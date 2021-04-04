package math_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1002 {
//�ͷ�
	public static void main(String[] args) {
		//�Է� : x1, y1, r1, x2, y2, r2
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int d = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);//sqrt���� �Ǽ� �������� ���ɼ� �־ ���� Ʋ���� ����
			int r = (r1+r2)*(r1+r2);				//���������� ���غ���. ������ ���·�
			int subR= (r1-r2)*(r1-r2);//�� �������� ���� �� ����
			
			if(d==0) {//�Ÿ��� 0�� ��
				if(r1==r2) bw.write("-1\n");//���� ��ġ�� ��
				else bw.write("0\n");
			}
			else {//�Ÿ��� 0�̻��� ��
				if(r==d || subR==d) bw.write("1\n");//���� || ����
				else if(r>d && subR<d) bw.write("2\n"); //* r1+r2>d && r1-r2<d : �����ϴ� ��� �ʰ� ~ �����ϴ� ��� �̸�
				else bw.write("0\n");
			}
				
			}
			br.close();bw.close();
		}catch (Exception e) {e.printStackTrace();}

	}

}
