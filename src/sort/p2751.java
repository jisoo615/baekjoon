package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2751 {
//�պ����� Merge Sort
	//������ �迭 arr, tmp �� �����Ѵ�
	static int[] arr;
	static int[] tmp;
	public static void main(String[] args) {
		try(
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int num = Integer.parseInt(br.readLine());
			arr = new int[num];
			tmp = new int[num];
			for(int i=0; i<num; i++) {//�Է�
				arr[i] = Integer.parseInt(br.readLine());
			}
			merge_sort(0, num-1);
			
			for(int i=0; i<num; i++) {//���
				bw.write(String.valueOf(arr[i])+"\n");
			}bw.flush();
		}catch (Exception e) {e.printStackTrace();}
	}
	
	public static void merge_sort(int start, int end) {//�պ�����
		if(start<end) {
			int mid = (start+end)/2; 
			merge_sort(start, mid); //����, 5/2�ϸ� 2.5->2�̱� ������ -1���� �ʿ� ����
			merge_sort(mid+1, end);
			//���� �ε����� ���ƴٴϸ鼭 ���� ���ϰ� �ڸ��� �ٲ���
			
			int p= start;
            int q= mid+1;
            int idx= p; //tmp�迭�� �ε���

            while(p<=mid || q<=end) { //�ε����� p(ó��~�߰�) or q(�߰�+1~��) :arr[p]�� ������ �ٲٰ� ++ ũ�� ��ٸ���(arr[p]>arr[q])�ɶ�����..
                if(q>end || (p<=mid && arr[p]<arr[q])) { //q�� �迭 �ۿ� �ְų�, p�� �߰����� �տ��ְ� p������ q���� �� Ŭ��
                    tmp[idx++]= arr[p++]; //�� ���� �� ����
                }else {
                    tmp[idx++]= arr[q++]; //q�� �迭�ȿ� �ְ�, p�� �ƹ����Գ��� arr[p]>arr[q] �ϋ�: arr[q]���� �� �����ϱ� ����
                }
            }

            for(int i=start; i<=end; i++) {
                arr[i]=tmp[i];
            }			
		}
		return;
	}

}
