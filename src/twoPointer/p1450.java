package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
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
	static int dp[][], prod[], n, c;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int[] origin = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) origin[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(origin);//����
		
		int[] A = new int[(int) Math.ceil(n/2)];
		int[] B = new int[n-A.length];
	    for(int i=0; i<A.length; i++) {
	    	A[i] = origin[i];
	    }
	    for(int i=A.length; i<n; i++) {
	    	B[i] = origin[i];
	    }
	    
	    LinkedList<Integer> list = makePartialSum(A);
	    list.addAll(makePartialSum(B));
	}
	
	static LinkedList<Integer> makePartialSum(int[] set) {//�κ��� ���ϱ� = �� ������
		LinkedList<Integer> list = new LinkedList<>();
		int start = 0, end = set.length, sum=0;
		
		while(true) {
			if(sum <= c) {
				list.add(sum);
				end--;
			}else {//sum > c
				end--;
			}
			break;
		}
		
		return list;
	}
}
