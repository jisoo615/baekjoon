package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/16234
//인구이동
public class PopulationMove {
	static boolean[][] visited;
	static LinkedList<int[]> que;
	static int total = 0;
	public static void main(String[] args) throws IOException{
		/*
		 입력받기
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] c = br.readLine().split(" ");
		int N = Integer.parseInt(c[0]);
		int L = Integer.parseInt(c[1]);
		int R = Integer.parseInt(c[2]);
		int[][] arr = new int[N][N];
		for(int i=0; i<N; i++) {
			c = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(c[j]);
			}
		}

		/*
		  dfs : 방문하지 않은 곳을 방문하며 한번의 dfs로 연합 가능한 곳까지 방문
		  다음날 더이상 방분할 곳이 없으면 종료
		 */
		visited = new boolean[N][N];

		int day = 0;
		while(true) {

			for(boolean[] v:visited)Arrays.fill(v, false);//초기화
			int assemble = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j]) continue;
					// 연합 맺은 후 인구수 맞퉈주기
					total = 0;
					que = new LinkedList<>();
					dfs(i, j, arr, L, R);

					int len = que.size();
					if(len<2) continue;
					assemble++;
					int average = total/len;

					while(!que.isEmpty()) {// 평균 인구수로 맞퉈주기
						int[] q = que.poll();
						arr[q[0]][q[1]] = average;
					}

				}
			}
			if(assemble==0) break;
			day++;
		}


		System.out.println(day);
	}

	static void dfs(int i, int j, int[][] arr, int L, int R) {
		int[] dx = {1, -1, 0, 0};// 우 좌 상 하 , 배열에선 하 상 우 좌
		int[] dy = {0, 0, 1, -1};
		visited[i][j] = true;
		total += arr[i][j];
		que.add(new int[] {i, j});

		for(int k=0; k<4; k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];

			if(nx>=0&&nx<arr.length && ny>=0&&ny<arr.length && !visited[nx][ny]) {//범위 내에 있을때
				int diff = Math.abs(arr[i][j] - arr[nx][ny]);
				if( diff >= L && diff <= R) {
					dfs(nx, ny, arr, L, R);
				}
			}
		}


	}

}
