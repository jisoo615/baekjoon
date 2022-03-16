package simulation;
// https://www.acmicpc.net/problem/17144
// 미세 먼지 안녕!
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MicroDirt_171447 {
	static int[][][] arr;
	static ArrayList<int[]> airPos;

	public static void main(String[] args) throws IOException{
		airPos = new ArrayList<>(); // 공기청정기 위치
		int answer = 0;
		/*
		 입력받기
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] c = br.readLine().split(" ");
		int R = Integer.parseInt(c[0]);
		int C = Integer.parseInt(c[1]);
		int T = Integer.parseInt(c[2]);
		arr = new int[R][C][2];
		// [r][c][0]=기존값 [r][c][1]=주변에서 받은 값
		for(int i=0; i<R; i++) {
			c = br.readLine().split(" ");
			for(int j=0; j<C; j++) {
				arr[i][j][0] = Integer.parseInt(c[j]);
				if(arr[i][j][0]==-1) airPos.add(new int[] {i, j});
			}
		}
		br.close();
while(T-->0) {
		/**
		 * 네 방향으로 확산시키기
		 */
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j][0]>0) {
					spread(i, j);
				}
			}
		}
		/**
		 * 칸마다 받은 먼지 더하기
		 */
		int sum=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j][0]==-1) continue;
				arr[i][j][0] += arr[i][j][1];
				arr[i][j][1] = 0;
				sum += arr[i][j][0];
			}
		}
		/**
		 * 위는 시계반대방향, 아래는 시계방향으로 '테두리만' 미세먼지 돌리기 -> 공기청정기 자리로 가면 미세먼지 사라짐
		 */
		sum -= rotateClockOtherwise(R, C);
		sum -= rotateClockWise(R, C);
		answer = sum;
}
	System.out.println(answer);

	}

	static int rotateClockOtherwise(int R, int C) {//반시계방향-> 제거된 미세먼지 양 반환
		//0,0             0,C-1
		//airPos[0]      airPos[0][0],C-1
		int airX = airPos.get(0)[0]; int airY = airPos.get(0)[1];

		for(int x=airX; x>0; x--) {
			arr[x][0][0] = arr[x-1][0][0];
		}
		for(int y=0; y<C-1; y++) {
			arr[0][y][0] = arr[0][y+1][0];
		}
		for(int x=0; x<airX; x++) {
			arr[x][C-1][0] = arr[x+1][C-1][0];
		}
		for(int y=C-1; y>0; y--) {
			arr[airX][y][0] = arr[airX][y-1][0];
		}

		int toLeave = arr[airX][airY][0];
		arr[airX][airY][0] = -1;
		arr[airX][airY+1][0] = 0;
		return toLeave;
		}

	static int rotateClockWise(int R, int C) {//시계방향-> 제거된 미세먼지 양 반환
		//airPos[1]       airPos[1][0],C-1
		//R-1,0           R-1, C-1
		int airX = airPos.get(1)[0]; int airY = airPos.get(1)[1];
		for(int x=airX; x<R-1; x++) {
			arr[x][0][0] = arr[x+1][0][0];
		}
		for(int y=0; y<C-1; y++) {
			arr[R-1][y][0] = arr[R-1][y+1][0];
		}
		for(int x=R-1; x>airX; x--) {
			arr[x][C-1][0] = arr[x-1][C-1][0];
		}
		for(int y=C-1; y>0; y--) {
			arr[airX][y][0] = arr[airX][y-1][0];
		}

		int toLeave = arr[airX][airY][0];
		arr[airX][airY][0] = -1;
		arr[airX][airY+1][0] = 0;
		return toLeave;
	}


	static void spread(int x, int y) {
		int[] dx = {-1, 1, 0, 0};// 상하좌우
		int[] dy = {0, 0, -1, 1};
		Queue<Integer> q = new LinkedList<>();
		// 남한테 줄 양 toGive
		int toGive = arr[x][y][0]/5;

		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0&&nx<arr.length && ny>=0&&ny<arr[0].length && arr[nx][ny][0]!=-1) {
				arr[nx][ny][1] += toGive; // 나중에 더할 미세먼지 쌓아두기
				q.add(nx); q.add(ny);
			}
		}
		// 기존 미세먼지에서 나눠준만큼 빼기
		arr[x][y][0] -= toGive*(q.size()/2);
	}

	static void printArr() {
		StringBuilder sb = new StringBuilder();
		sb.append("=========================\n");
		for(int[][] a:arr) {
			for(int[] b:a) {
				sb.append(b[0]).append(" ");
			}sb.append("\n");
		}
		sb.append("=========================\n");
		System.out.println(sb.toString());
	}

}
