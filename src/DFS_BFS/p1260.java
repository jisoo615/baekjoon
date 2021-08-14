package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p1260 {
	static int[][] arr;	
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		StringTokenizer st = new StringTokenizer(br.readLine());           
		int N = Integer.parseInt(st.nextToken());	// ���� ����
		int M = Integer.parseInt(st.nextToken());	// ���� ����       
		int V = Integer.parseInt(st.nextToken());	// Ž���� ������ ������ ��ȣ
        
		arr = new int[N + 1][N + 1];      
		check = new boolean[N + 1];
        
		// ��� , ���� �� �ʱ�ȭ
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine()); 
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s][e] = 1;
			arr[e][s] = 1;
		}
		
		dfs(V);
		sb.append("\n");
		dfs_stack(V);//���� ���� �߰� ���� �Ѱ�.
		sb.append("\n");
		bfs(V);
		
		System.out.print(sb);

	}
	
	static void dfs(int startV) {
		sb.append(startV+" ");
		check[startV] = true;
		for(int i=1; i<check.length; i++) {
			if(i !=startV && !check[i] && arr[startV][i] == 1) {
				dfs(i);
			}
		}
	}
	
	static void dfs_stack(int startV) {//��Ͱ� �ƴ϶� stack���� �����ϸ� lifo�� ������ ���� Ž��-->Ž�� ����� �ӵ��� ���� ���� �������̻�!
		Arrays.fill(check, false);
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.add(startV);
		check[startV] = true;
		
		while(!stack.isEmpty()){
			int cur_node = stack.pop();
			sb.append(cur_node).append(" ");
			for(int i=1; i<check.length; i++) {
				if(i !=cur_node && !check[i] && arr[cur_node][i] == 1) {
					stack.add(i);
					check[i] = true;
				}
			}
		}
		
	}
	
	static void bfs(int startV) {
		Arrays.fill(check, false);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(startV);
		check[startV] = true;
		
		while(!queue.isEmpty()) {
			int level = queue.poll();
			sb.append(level+" ");
			for(int i=1; i<check.length; i++) {
				if(i != level && !check[i] && arr[level][i]==1 ) {
					queue.add(i);
					check[i] = true;
				}
			}
		}
		sb.append("\n");
	}

}
