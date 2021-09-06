package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//�� ������, meet in the middle �˰��� ����Ѵ�.
/** <2^N�� �ȵǴµ� 2^(N/2)�� �ɰŰ��� ��>
* ������ �� �κ��������� �ɰ���, �κ����� A, B��� ����. 
     A�� ���Ҵ� n/2���̰� B�� �������� ���ִ�.
* A���� ���� �� �ִ� ��� �κ����յ��� ������ ���� ����ϰ�, �迭 X�� �����Ѵ�.
    ���������� B���� ���� �� �ִ� ��� �κ������� ������ ���� ����ϰ�, �迭 Y�� ����. X�� Y�� ũ��� �ִ� 2^(n/2)
* X�� Y�� �����Ͽ� ���� S���� ���� ���� ���Ѵ�. Y�� ���� �� X�� �� ���Ҹ��� ��ȸ�Ѵ�. 
    Y���� ���� Ž���� �����Ͽ� x + y �� S�� ���� y�� ã�´�.
 **/
public class p1450 {
	static int dp[][], arr[], n, c;
	static ArrayList<Integer> lista, listb, result;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) arr[i]= Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		lista = new ArrayList<>();
		listb = new ArrayList<>();
		makePartialSum(0, n/2, 0, lista);
		makePartialSum(n/2, n, 0, listb);
		
		Collections.sort(listb);//�� ����Ʈ�� �������� �����صα� (listb�� ����)
		/* 
		 * �κ��� ������ �Ǵٽ� �κ����� ������ �ʾƵ� ��. �Ǵٽ� �Ѵٸ� �ߺ��� ��
		 * ex) 1 2 3 -> 0 1 2 3 3 4 5 6 (8��)
		 * 0 1 2 3 / 0 3
		 * -> 0 3 1 4 2 5 3 6 (8��)
		 */
		int answer = 0;
		for(int i=0; i<lista.size(); i++) {
			answer += binarySearch(0, listb.size()-1, lista.get(i) ) + 1;
		}
		
		//System.out.println(lista.toString());
		//System.out.println(listb.toString());
		System.out.println(answer);
	}
	
	static void makePartialSum(int start, int end, int sum, ArrayList<Integer> list) {//�κ��� ���ϱ� = �� ������		
		
		if(sum > c) return;
		if(start == end) {
			list.add(sum);
			return;
		}
			
		makePartialSum(start+1, end, sum + arr[start+1], list);
		makePartialSum(start+1, end, sum, list);
		
	}
	
	static int binarySearch(int start, int end, int val) {//
		int mid, index=-1;
		while(start <= end) {
			mid = (start+end)/2;
			if(listb.get(mid)+val <= c) {
				index = mid;
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return index;
	}

}
