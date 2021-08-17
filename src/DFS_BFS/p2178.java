package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//�̷� Ž��, �ִܰ�� ���ϴ� ���� BFS�� ���Ѵ�. (�ʺ�켱 Ž��)
public class p2178 {
	static int N, M, map[][];
	static boolean visited[][];
	static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';//�̷��� '0'�� 0�� �ǰ�, '1'�� 1�� ��(�ƽ�Ű�ڵ� ���� �̿��ؼ�)
			}
		}
		bfs(0, 0);
		System.out.print(map[N-1][M-1]);
	
	}
	
	public static void bfs(int x, int y) {
		Queue< int[] > que = new LinkedList<>();
		que.offer(new int[] {x, y});
		
		while(!que.isEmpty()) {
			int temp[] = que.poll();
			visited[x][y] = true;
			
			for(int i=0; i<4; i++) {
				int xx = temp[0] + direction[i][0];
				int yy = temp[1] + direction[i][1];
				
				if(xx >= 0 && xx<N && yy >= 0 && yy<M) {
					if(map[xx][yy] != 0 && !visited[xx][yy]) {//1�϶��� �ƴ϶� 0�� �ƴҶ�!
						que.add(new int[] {xx, yy});
						visited[xx][yy]= true;
						map[xx][yy] = map[temp[0]][temp[1]] + 1;//�ռ��Ϳ� +1
					}
				}
			}
		}
		
	}

}
