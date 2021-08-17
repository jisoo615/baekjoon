package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1012 {
	static int arr[][], width, height, cabbage;
	static boolean visited[];
	static final int[][] upsidedown = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//케이스 개수
		
		for(int T=0; T<N; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		cabbage = Integer.parseInt(st.nextToken());
		
		arr = new int[height][width];
		
		for(int i=0; i<cabbage; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		
		int cnt = 0;
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(arr[i][j]==1) {
					cnt += 1;
					dfs(i, j);
				}
			}
		}
		
		sb.append(cnt).append("\n");
		
		}
		
		System.out.print(sb);
	}
	
	static void dfs(int x, int y) {
		arr[x][y] = 0;
		for(int i=0; i<4; i++) {
			int xx = x + upsidedown[i][0];
			int yy = y + upsidedown[i][1];
			if(xx < 0 || yy < 0 || xx >= height || yy >= width) {//배열 넣어가면 안되니까.
				continue;
			}
			if(arr[xx][yy] == 1) {
				dfs(xx, yy);//
				}
		}
	}

}
