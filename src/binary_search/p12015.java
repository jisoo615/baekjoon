package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


//참고 블로그 : https://23dotory.tistory.com/24

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
		list.add(A[0]);//첫번째 수는 걍 집어넣고
		
		for(int i=1; i<N; i++) {
			int value = A[i];
			
			if(value > list.get(list.size()-1)) {//보다 크면 추가
				list.add(A[i]);
				
			}else {//더 작거나 같으면 lower_bound해서 위찾아 바꾸기.
				int indx = Collections.binarySearch(list, value);//value가 있므면 양수 없으면 음수를 반환함(0번째 자리부터 -1 -2 ...)
																
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
