package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

		Collections.sort(listb);//
		/*
		 * 부분합 끼리는 또다시 부분합을 구하지 않아도 됨. 또다시 한다면 중복이 됨
		 * ex) 1 2 3 -> 0 1 2 3 3 4 5 6 (8개)
		 * 0 1 2 3 / 0 3
		 * -> 0 3 1 4 2 5 3 6 (8개)
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
