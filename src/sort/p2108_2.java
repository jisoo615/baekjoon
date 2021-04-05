package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//count�������� �ذ��� ������ ��Ÿ�� ���� + ������ ��Ǯ���� ������ ���, �ֺ󰪴ٸ�
public class p2108_2 {

	public static void main(String[] args) {
		try(	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int n = Integer.parseInt(br.readLine());
			int[] cnt = new int[8001]; //0 ~ 8000 -> -4000 ~ 4000
			int sum = 0; int first=0, last=0; int center=0;
			for(int i=0; i<n; i++) {
				int number = Integer.parseInt(br.readLine());
				cnt[number+4000] +=1;
				sum += number;
			}//���� �� ����
			
			int total=0;
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
					
					if(total==0) first=i-4000;
					if(total<=n-1) last=i-4000;
					if(total<(n+1)/2 ) { //�߰����� ���ϴ� ��:total�� (n+1)/2���� ���� �ɶ����� ������ �׶�i-4000�� �߰����� ��.
						center = i-4000;				//�ֳ�,cnt�� 12222�� �־����� 6<5 �Ǳ� ��, 4�϶� center��
					}total += cnt[i];//total�� ���� ���߿� �������ϱ� ���ų� ������ �ƴ� ������ �� �ϸ� �۰ų� ������ �Ǵ� �Ŷ� ����..
					
					if(total>=n) break;//�� �˻������� ���̻� ���� �ʰ� break
				}
			}
			int small = Math.min(first, last); int big = Math.max(first, last);
			
			bw.write(String.valueOf(Math.round((sum/n)*10)/10)+"\n"
					+String.valueOf(mode)+"\n"//�ֺ�
					+String.valueOf(center)+"\n"//�߰���
					+String.valueOf(big-small)+"\n"//�ִ񰪰� �ּڰ��� ����
					);
			bw.flush();
	}catch(Exception e) {e.printStackTrace();}
	}
}
