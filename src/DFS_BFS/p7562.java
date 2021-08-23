package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7562 {
	static int T, L, mat[][];
	static boolean visited[][];
	static StringBuilder sb= new StringBuilder();

	public static void main(String[] args) throws IOException{
		int x, y; int x_dest, y_dest;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			L = Integer.parseInt(br.readLine());
			mat = new int[L][L];
			visited = new boolean[L][L];
			
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			x_dest = Integer.parseInt(st.nextToken());
			y_dest = Integer.parseInt(st.nextToken());
			
			visited[x][y] = true;
			bfs(x, y, x_dest, y_dest);
		}
		
		System.out.print(sb);

	}
	
	static public void bfs(int x, int y, int x_dest, int y_dest) {
		int ny, nx;
		int[] x_direc = {-2, -2, 2, 2, -1, 1, 1, -1};//8°³
		int[] y_direc = {-1, 1, -1, 1, 2, 2, -2, -2};
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		q.offer(y);
		
		while(!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
			
			if(x==x_dest && y==y_dest) {
				sb.append(mat[x][y]).append("\n");
				return;
			}
			
			for(int i=0; i<8; i++) {
				nx = x + x_direc[i];
				ny = y + y_direc[i];
				
				if(0>nx || nx>=L || 0>ny || ny>=L) continue;
				
				if(visited[nx][ny]==false) {
					q.offer(nx);
					q.offer(ny);
					visited[nx][ny]=true;
					mat[nx][ny] = mat[x][y] + 1;
				}
			}
		}
		
	}

}
