package character_string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p2675_tokenizer {//�̰� ������(128ms) �ֳ�, ��±��� buffered�� �����ϱ�(��Ʈ�� ������ bw�� �� ����ؼ� println�����߱� ����)

			public static void main(String[] args) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
			try {
				int x = Integer.parseInt(br.readLine());
				
				for(int i=0; i<x; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine(), " "); //���̽� ����
					int y = Integer.parseInt(st.nextToken());
					String test = st.nextToken();
					
						for(int k=0; k<test.length(); k++) {//���ڿ� �ε���
							for(int j=0; j<y; j++) { //�ݺ��� ���⼭
								bw.write(test.charAt(k));
							}
						}
						bw.write("\n");
				}
				bw.flush();
			}catch(Exception e) {}
				
			}
	}