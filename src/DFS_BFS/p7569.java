package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7569 {
	static int N, M, H, board[][][];
	static boolean visited[][][];
	static Queue<int[]> que = new LinkedList<>();
	static int[][] dir = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
	static int result = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());//가로
		M = Integer.parseInt(st.nextToken());//세로
		H = Integer.parseInt(st.nextToken());
		board = new int[H][M][N];
		visited = new boolean[H][M][N];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<M; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int k=0; k<N; k++) {
					board[i][j][k] = Integer.parseInt(st.nextToken());
					if(board[i][j][k]==1) {
						que.add(new int[] {i,j,k});//
						visited[i][j][k] = true;
					}
				}
			}
		}
		
		bfs();
		
		System.out.print(result);
	}
	
	public static void bfs() {
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			for(int i=0; i<6; i++) {
				int hh = cur[0] + dir[i][0];
				int xx = cur[1] + dir[i][1];
				int yy = cur[2] + dir[i][2];
				
				if(0<=hh && hh<H && 0<=xx && xx<M && 0<=yy && yy<N) {
					if(board[hh][xx][yy] == 0 && !visited[hh][xx][yy]) {
						que.add(new int[] {hh, xx, yy});
						visited[cur[0]][cur[1]][cur[2]] = true;
						board[hh][xx][yy] = board[cur[0]][cur[1]][cur[2]] + 1;
					}
				}
				}
		}
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<M; j++) {
				for(int k=0; k<N; k++) {
					if(board[i][j][k] == 0) {
						result = -1;
						return;
					}
					result = Math.max(result, board[i][j][k]);
				}
			}
		}
		
		result -= 1;
		
	}

}
