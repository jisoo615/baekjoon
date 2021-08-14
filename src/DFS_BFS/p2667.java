package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2667 {
	static int arr[][], N, houseCnt, houseSize[];
	static int[][] upsidedown= {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//i,j좌표의 상하좌우를 살피기 위한 배열
 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+2][N+2];
		houseSize = new int[N*N+1];
		
		for(int i=1; i<=N; i++) {
			String[] st = br.readLine().split("");
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st[j-1]);
			}
		}
		houseCnt=0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(arr[i][j] == 1) {
					houseCnt++;
					dfs(i, j);
				}
			}
		}
		
		Arrays.sort(houseSize);
		StringBuilder sb = new StringBuilder();
		sb.append(houseCnt).append("\n");
		for(int i=N*N-houseCnt+1; i<=N*N; i++) {
			sb.append(houseSize[i]).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void dfs(int i, int j) {
		arr[i][j] = 0;
		houseSize[houseCnt] += 1;
		for(int k=0; k<4; k++) {
			int x = i + upsidedown[k][0];
			int y = j + upsidedown[k][1];
			
			if(arr[x][y]==1) {
				dfs(x, y);
			}
		}

	}

}
