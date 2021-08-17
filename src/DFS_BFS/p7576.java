package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
	
public class p7576 {
	
	static int N, M, map[][];
	static int result =0;
	static boolean[][] visited;
	static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static Queue< int[] > que = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		System.out.print(result);

	}
	
	public static void bfs() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) {
					que.add(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			for(int i=0; i<4; i++) {
				int xx = cur[0] + direction[i][0];
				int yy = cur[1] + direction[i][1];
				
				if(xx>=0 && xx<N && yy>=0 && yy<M) {
					if(map[xx][yy]==0 && !visited[xx][yy]) {
						que.add(new int[] {xx, yy});
						visited[xx][yy] = true;
						map[xx][yy] = map[cur[0]][cur[1]] + 1;
					}
				}
			}
		}
		
		//bfsŽ�� �������� map�� ��ü ���鼭 ��� ���ϱ�
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					result = -1;
					return;//�ϳ��� 0�� �ִٴ� �� �丶�䰡 �� ���� ���Ѵٴ°�. ->���� : -1
				}
				result = Math.max(result, map[i][j]);
			}
		}
			result -= 1;//1���ֱ� ���� �;����� ����(ù��) ���ߵǴϱ�
	}

}
