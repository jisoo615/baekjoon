package dp_backwards;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p12852 {
	static int dp[];
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n+1]; //dp[x]=숫자n이 x가 되는 최소 연산 횟수

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[n] = 0;
		bfs(n);

		StringBuilder sb = new StringBuilder();

		sb.append(dp[1]).append("\n");
		LinkedList<Integer> answer = findPath();
		while(!answer.isEmpty()) {
			sb.append( answer.pollLast() ).append(" ");
		}
		System.out.print(sb);
		sc.close();
	}

	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		while(!q.isEmpty()) {//먼저 숫자 num에 대해 할 수 있는 연산을 체크, 카운트 높여준다.
									//0부터 시작이 아니라 n부터 시작인 것이 보통 dp와 다르점일 뿐인듯
			int num = q.poll();

			if(num==1) break;//=continue

			if(num%3==0 && dp[num/3] > dp[num]+1) {
				dp[num/3] = dp[num] + 1;
				q.add(num/3);
			}
			if(num%2==0 && dp[num/2] > dp[num]+1) {
				dp[num/2] = dp[num] + 1;
				q.add(num/2);
			}
			if(dp[num-1] > dp[num] + 1) {
				dp[num-1] = dp[num] + 1;
				q.add(num-1);
			}
		}

		return;
	}

	static LinkedList<Integer> findPath() {//런타임 에러남 시간초과
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		int k = 0;
		while(k <= n) {

			k = list.peekLast();

			if(k==n) break;

			if( 3*k<=n && dp[k*3] == dp[k]-1 ) {//3*k<=n 요거 안해주면 인덱스 에러
				list.add(k*3);

			}else if( 2*k<=n && dp[k*2] == dp[k]-1 ) {
				list.add(k*2);

			}else if( k-1<=n && dp[k+1] == dp[k]-1 ) {
				list.add(k+1);
			}
		}

		return list;
	}

	static boolean isPossibleResult(int now, int become) {
		if(now*3==become || now*2==become || now+1==become) {
			return true;
		}
		return false;
	}

}
