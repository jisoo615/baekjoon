package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
//투 포인터, meet in the middle 알고리즘 사용한다.
/** <2^N은 안되는데 2^(N/2)는 될거같을 때>
* 집합을 두 부분집합으로 쪼개고, 부분집합 A, B라고 하자. 
     A의 원소는 n/2개이고 B는 나머지가 들어가있다.
* A에서 구할 수 있는 모든 부분집합들의 원소의 합을 계산하고, 배열 X에 저장한다.
    마찬가지로 B에서 구할 수 있는 모든 부분집합의 원소의 합을 계산하고, 배열 Y에 저장. X와 Y의 크기는 최대 2^(n/2)
* X와 Y를 조합하여 합이 S보다 작은 것을 구한다. Y를 정렬 후 X의 각 원소마다 순회한다. 
    Y에서 이진 탐색을 진행하여 x + y ≤ S인 원소 y를 찾는다.
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
		Arrays.sort(origin);//정렬
		
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
	
	static LinkedList<Integer> makePartialSum(int[] set) {//부분합 구하기 = 투 포인터
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
