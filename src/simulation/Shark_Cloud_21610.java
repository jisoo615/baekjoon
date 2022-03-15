package simulation;
//https://www.acmicpc.net/problem/21610
// 마법사 상어와 비바라기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Shark_Cloud_21610 {

	public static void main(String[] args) throws IOException{
		/*
		 입력받기
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] c = br.readLine().split(" ");
		int N = Integer.parseInt(c[0]);
		int M = Integer.parseInt(c[1]);
		int[][] arr = new int[N][N];
		for(int i=0; i<N; i++) {
			c = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(c[j]);
			}
		}
		/**
		 * 방향, 거리 만큼 수행하기
		 * 1. 초기 구름에서 방향만큼 움직이고, 각 구름에 1씩 더해주고, 각 구름에서 대각선의 물이 0이상이면 개수만큼 +1
		 * 2. 1수행 후 구름 사라지고, 구름 있던 곳 제외 모든 배열에서 2 이상인 곳에 구름 생기고 -2 해줌
		 * 3. 또다시 방향대로 구름 움직이기 반복
		 * (x, y) 1,1 ~ N, N 배열은 x
		 */
		int[] dx = {0, -1, -1, -1, 0, 1, 1, 1}; //←, ↖, ↑, ↗, →, ↘, ↓, ↙
		int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
		//초기 구름 (N, 1), (N, 2), (N-1, 1), (N-1, 2)
		LinkedList<int[]> cloud = new LinkedList<>();
		cloud.add(new int[] {N-1, 0}); cloud.add(new int[] {N-1,1});
		cloud.add(new int[] {N-2, 0}); cloud.add(new int[] {N-2, 1});
		boolean[][] visited = new boolean[N][N];
		/**
		 * M만큼 명령받기 d방향, s칸
		 */
		for(int i=0; i<M; i++) {
			c = br.readLine().split(" ");
			int d = Integer.parseInt(c[0])-1;
			int s = Integer.parseInt(c[1]);

			/**
			 * 구름 이동시키기
			 */
			int len = cloud.size();// 기존 구름개수 고정..
			for(int[] v : arr)System.out.println(Arrays.toString(v));
			System.out.println();
			for(int j=0; j<len; j++) {
				int[] point = cloud.removeFirst();

				int x = point[0]+dx[d]*s;
				int y = point[1]+dy[d]*s;
				if(x<0||x>=N || y<0||y>=N) {//범위 넘으면 반대편으로 넘겨줘야함
					x %= N; y %= N;
					x = x<0 ? N+x : x;
					y = y<0 ? N+y : y;
				}
				arr[x][y] += 1;// 먼저 +1 해주기
				cloud.addLast(new int[] {x, y}); //이동한 구름 저장
				visited[x][y] = true; // 이동된 구름 체크하기
			}

			/**
			 * 이동된 구름에서 각 point에서 대각선에 있는 물 바구니 만큼 +1
			 */
			while(!cloud.isEmpty()) {
				int[] point = cloud.removeFirst();
				int cnt = 0;
				for(int k=1; k<8; k+=2) {// 대각선 1 3 5 7 방향
					int x = point[0]+dx[k];
					int y = point[1]+dy[k];
					if(x<0||x>=N || y<0||y>=N) continue;
					if(arr[x][y]>0) cnt++;
				}

				arr[point[0]][point[1]] += cnt;
			}

			/**
			 * visited=false인 부분에서 2 이상인 곳 -2해주고 구름으로 만들기
			 */
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(visited[j][k]) {
						visited[j][k] = false;
						//구름 체크 풀어주기
					}else {//visited = false
						if(arr[j][k]>=2) {
							arr[j][k]-=2;
							cloud.add(new int[] {j, k});
						}
					}
				}
			}
/**
 * 여기까지 M 한줄 끝나는 곳.
 */

	}
		br.close();
		//물의 양의 합
		int sum = 0;
		for(int[] a : arr) {
			for(int aa: a) {
				sum += aa;
			}
		}
		System.out.println(sum);
	}
}
