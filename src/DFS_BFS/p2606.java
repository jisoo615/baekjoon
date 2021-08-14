package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p2606 {
	static int arr[][];
	static boolean check[];
	static StringBuilder sb;
//bfs사용해보자
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		check = new boolean[N+1];
		sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from][to] = 1;
			arr[to][from] = 1;
		}
		
		sb.append("bfs 탐색결과: ");
		bfs(1);
		
		Arrays.fill(check, false);
		sb.append("dfs 탐색결과: ");
		dfs(1);
		sb.append("\n");
		
		//시작인 1을 제외하고 감염된 컴퓨터의 수는?
		int virused = 0;
		for(int i=2; i<check.length; i++) {//1제외하고 시작
			if(check[i]) {
				virused += 1;
			}
		}
		System.out.print(sb);
		System.out.print(virused);

	}
	
	static void bfs(int startV) {
		Deque<Integer> queue = new LinkedList<Integer>();
		queue.add(startV);
		check[startV] = true;
		
		while(!queue.isEmpty()) {
			int cur_node = queue.poll();
			sb.append(cur_node).append(" ");
			for(int i=1; i<check.length; i++) {
				if(i != cur_node && !check[i] && arr[cur_node][i]==1 ) {
					queue.add(i);
					check[i] = true;
				}
			}
		}
		sb.append("\n");
	}
	
	static void dfs(int startV) {
		sb.append(startV).append(" ");
		check[startV] = true;
		
		for(int i=1; i<check.length; i++) {
			if(i!=startV && !check[i] && arr[startV][i]==1) {
				dfs(i);
			}
		}
	}

}
