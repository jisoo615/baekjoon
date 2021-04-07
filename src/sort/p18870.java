package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class p18870 {
//��ǥ����_�ð��ʰ�
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		int[] arr = new int[n];
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(temp[i]);
			
			//�ߺ����� �ϸ鼭 list�� �ֱ�-������
			if(!list.contains(arr[i])) {
				list.add(arr[i]);
			}
		}
	
		Collections.sort(list); //��������
		//arr���� ���� list�� �ε����� ���
		StringBuilder sb = new StringBuilder();
		for(int k=0; k<n; k++) {
			sb.append(Collections.binarySearch(list, arr[k])+" ");//����Ž��
		}System.out.println(sb);
	}

}
