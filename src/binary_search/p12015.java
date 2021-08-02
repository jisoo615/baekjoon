package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


//���� ��α� : https://23dotory.tistory.com/24

public class p12015 {
	static int N;
	static int A[];
	static ArrayList<Integer> list;
	static int length=0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList<>();
		list.add(A[0]);//ù��° ���� �� ����ְ�
		
		for(int i=1; i<N; i++) {
			int value = A[i];
			
			if(value > list.get(list.size()-1)) {//���� ũ�� �߰�
				list.add(A[i]);
				
			}else {//�� �۰ų� ������ lower_bound�ؼ� ��ã�� �ٲٱ�.
				int indx = Collections.binarySearch(list, value);//value�� �ֹǸ� ��� ������ ������ ��ȯ��(0��° �ڸ����� -1 -2 ...)
																
				if(indx >= 0) {
					list.set(indx, value);
				}else {
					list.set(-indx-1, value);
				}
			}
		}
		
		System.out.print(list.size());
		
	}

}
