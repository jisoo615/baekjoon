package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//merge sort�� ��������� �ֺ� ���� �� ������..
public class p2108 {
	static int[] tmp;
	static int[] data;
	public static void main(String[] args) {
		try(	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int n = Integer.parseInt(br.readLine());
			data = new int[n];
			tmp = new int[n];
			for(int i=0; i<n; i++) {
				data[i] = Integer.parseInt(br.readLine());
			}
			merge_sort( 0, n-1);
			int sum = 0; int middle=n/2;/*��� �ε���*/
			//int temp =0; int mode = 0; //mode�� �ֺ�, temp�� �ӽ� 
			//�ֺ�:�ֺ��� ������ ���������� �ι�°�� ���� ���� ����Ѵ�//hash�ʰ� iterator�� ������ Ǯ��� ��.(int�迭�� ���Ұ� �ƴϸ�)

			for(int i=0; i<n; i++) {
				sum +=data[i];
			}
		
			bw.write(String.valueOf((int)Math.round((double)sum/n))+"\n"
				+String.valueOf(data[middle])+"\n"
				+String.valueOf(" �������� ")+"\n"
				+String.valueOf(data[n-1]-data[0])+"\n");
			bw.flush();
		}catch (Exception e) { e.printStackTrace();	}

	}
	
	
	public static void merge( int start, int end) {
		int mid = (start+end)/2;
		int leftindx = start;
		int rightindx = mid+1;
		int tmpindx = start; //�ӽù迭�� �����Ҷ� �� �ε���
		
		while(leftindx<=mid && rightindx<=end) {
			if(data[leftindx]>data[rightindx]) tmp[tmpindx++] = data[rightindx++];
			else if(data[leftindx]<data[rightindx]) tmp[tmpindx++] = data[leftindx++];
			else {//���� ���� ���
				tmp[tmpindx++] = data[leftindx++];
				tmp[tmpindx++] = data[rightindx++];
			}
		}//�����̳� ������ �ϳ��� ������ while���� ���´�. �׷��� �Ʒ� if else ���� �ʿ�
		
		if(leftindx>mid) {//left�� ���� ��������
			for(int i=rightindx; i<=end; i++) { tmp[tmpindx++] = data[i]; }//������ ������ �ָ��� ����
		}
		else if(rightindx>end) {//right�� ���� ��������
			for(int i=leftindx; i<=mid; i++) { tmp[tmpindx++] = data[i]; }//���� ������ �ָ��� ����
		}
		
		//���������� tmp�� ���ĵ� ���� data�� �Űܾ� ��
		for(int i=start; i<=end; i++) {
			data[i] = tmp[i];
		}			
	}
	
	
	public static void merge_sort( int start, int end) {
		int mid = (start+end)/2;
		if(start<end) {//while�� �Ҷ� �ȵǴ��� if�� �ٲٴϱ� ���� ����??
			merge_sort( start, mid);
			merge_sort( mid+1, end);
			merge( start, end);
		}
	}

}
