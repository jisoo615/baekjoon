package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1697 {
	static int N, K;
	static int result = 0;
	static int[] check = new int[100001];
	static Queue<Integer> que = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N==K) {
			System.out.print(0);
		}else {
			bfs(N);
			System.out.print(result);
		}

	}
	
	public static void bfs(int n) {
		que.add(n);
		check[n] = 1;
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			
			for(int i=0; i<3; i++) {
				int next = cur;
				if(i==0) {
					next += 1;
				}else if(i==1) {
					next -= 1;
				}else {
					next *= 2;
				}
				
				if(next == K) {
					result = check[cur];
					return;
				}
				
				if(0<=next && next<100001 && check[next]==0) {
					que.add(next);
					check[next] = check[cur] + 1;
				}
			}
		}
	}

}
