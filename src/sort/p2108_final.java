package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class p2108_final {

	public static void main(String[] args) {
		try(	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int n = Integer.parseInt(br.readLine());
			int[] cnt = new int[8001]; //0 ~ 8000 -> -4000 ~ 4000
			int[] arr = new int[n];
			
			int sum=0;
			for(int i=0; i<n; i++) {
				int number = Integer.parseInt(br.readLine());
				arr[i]=number;
				cnt[number+4000] +=1;
				sum += number;
			}//���� �� ����
			
			Arrays.sort(arr);
			int mean = (int)Math.round((double)sum/n);//���
			int center = arr[(n-1)/2];//�߰���
			int coverage = arr[n-1]-arr[0];//�ּڰ��� �ִ� �� ��(=����)
			
			ArrayList<Integer> list = new ArrayList<>();
			int max = 0;//�ֺ� ���ϱ�
			for(int i=0; i<8001; i++) {
				if(cnt[i]>0) {
					if(cnt[i]>max) {
						max = cnt[i];
						list.clear();
						list.add(i-4000);
					}
					else if(list.size()==1 && cnt[i]==max) {
						list.add(i-4000);
					}
				}
			}
			
			bw.write(mean+"\n");
			bw.write(center+"\n");
			if(list.size()==1) {
				bw.write(list.get(0)+"\n");
			}else bw.write(list.get(1)+"\n");
			bw.write(coverage+"\n");
			bw.flush();			
			
		}catch (Exception e) {e.printStackTrace();}

	}

}
