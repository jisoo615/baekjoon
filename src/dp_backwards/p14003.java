package dp_backwards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p14003 {
	static int A[], dp[], checknumber[], lisIndex[];//dp[x] = x를 포함하는 최대 증가수열 길이
	static int n;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		A = dp = checknumber = lisIndex = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int topnum=0;
		lisIndex[0] = 0;
		checknumber[topnum]= Integer.parseInt(st.nextToken());
		A[0] = checknumber[topnum++];

		for(int i=1; i<n; i++) {
			lisIndex[i] = i;
			int number = Integer.parseInt(st.nextToken());
			A[i] = number;
			if(checknumber[topnum-1] < number) {
				lisIndex[i] = topnum;
				checknumber[topnum++] = number;

			}else {
				lower_bound(number, i);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(topnum).append("\n");

		Stack<Integer> ans = new Stack<>();
		for(int i=n-1; i>=0; i--) {

			if(lisIndex[i] == topnum) {
				ans.push(A[i]);
				topnum--;
			}
		}

		while(!ans.isEmpty()) {
		    sb.append(ans.pop()).append(" ");
		}

		System.out.println(sb);

	}

	static int lower_bound(int findNum, int i) {//lower bound
		int start = 0;
		int end = n-1;
		int mid=0;

		while(start < end) {
			mid = (start+end)/2;
			if( findNum > A[mid] ) {
				start = mid+1;
			}else {//key <= arr[mid]
				end = mid;
			}
		}
		lisIndex[i] = end;
		checknumber[end]= findNum;
		return end;
	}

}
