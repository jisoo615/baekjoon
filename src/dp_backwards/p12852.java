package dp_backwards;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

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
		for(Integer a : findPath()) sb.append(a).append(" ");
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
			if(num%2==0) {
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

	static Stack<Integer> findPath() {
		Stack<Integer> q = new Stack<Integer>();
		q.push(1);
		while(q.peek() <= n) {

			int now = q.peek();

			if(now==n) break;

			for(int i = q.peek(); i<=n; i++) {

				if( dp[i] == now - 1 && isPossibleResult(now, i)) {
					q.push(i);	//지금 숫자. (dp[])횟수보다 1많은 경우의 숫자 && 그 숫자가 3가지 연산중 하나를 통해 become이 될 수 있을때
				}
			}

		}
		return q;
	}

	static boolean isPossibleResult(int now, int become) {
		if(now*3==become || now*2==become || now+1==become) {
			return true;
		}
		return false;
	}

}
