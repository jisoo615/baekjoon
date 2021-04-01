package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//�ذ��� ������ ��Ÿ�� ����
public class p2108_2 {

	public static void main(String[] args) {
		try(	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int n = Integer.parseInt(br.readLine());
			int[] cnt = new int[8001]; //-4000~4000����: �ε��� 0~3999�� ����, 4000�� 0, 4001~8000�� ���
			int sum = 0; int first=0, last=0; int center=0;
			for(int i=0; i<n; i++) {
				int number = Integer.parseInt(br.readLine());
				cnt[number+4000] +=1;
				sum += number;
			}
			int total=0;int index=0;
			boolean flag =false; int mode=0; int mode_max=0;
			/*flag�� �󵵼��� ������ ���Դ��� üũ�ϴ°�. mode�� �ֺ�, mode_max�� �󵵼�*/
			for(int i=0; i<=8000; i++) {
				if(cnt[i]>0) {
					if(cnt[i]>mode_max) {//���� ���̳��� Ƚ���� ������ 2������ ���� ��(=�� ������������ �ι�°)�� �ֺ����� ���Ѵ�.
						mode_max = cnt[i];
						mode = i-4000;
						flag = true;
					}else if(flag==true && mode_max==cnt[i]){//�� �ּ� ������ ���� Ƚ���� �ι�° ���Ŀ� �����°� �ʿ���⿡ 
						mode_max = cnt[i];
						mode = i-4000;
						flag = false;						//flag�� false�� ���ְ� �� ū ���� ã�� �Ѵ�.
					}
					
					if(index==0) first=i-4000;
					else if(index>0) last=i-4000;
					if(total<(n+1)/2 ) { //�߰����� ���ϴ� ��:total�� (n+1)/2���� ���� �ɶ����� ������ �׶�i-4000�� �߰����� ��.
						center = i-4000;				//�ֳ�,cnt�� 1222�� �־����� 
					}total += cnt[i];//total�� ���� ���߿� �������ϱ� ���ų� ������ �ƴ� ������ �� �ϸ� �۰ų� ������ �Ǵ� �Ŷ� ����..
					index++;
					if(total>n) break;
				}
			}
			
			bw.write(String.valueOf(Math.round(sum/n))+"\n"//���
					+String.valueOf(mode)+"\n"//�ֺ�
					+String.valueOf(center)+"\n"//�߰���
					+String.valueOf(last-first)+"\n"//�ִ񰪰� �ּڰ��� ����
					);
			bw.flush();
	}catch(Exception e) {e.printStackTrace();}
	}
}
