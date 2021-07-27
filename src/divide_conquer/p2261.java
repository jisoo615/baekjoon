package divide_conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2261 {
	static int dots[][];
//첫째 점과 가장 가까운 점과의 거리의 제곱을 구하라
	//실패-->최대입력수가 100000개이기 떄문에 O(N^2)--> 분할정복으로 다시 풀기
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			dots = new int[n][2];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				dots[i][0] = Integer.parseInt(st.nextToken());//x좌표
				dots[i][1] = Integer.parseInt(st.nextToken());//y좌표
			}
			
			int answer= Integer.MAX_VALUE;
			for(int i=1; i<n; i++) {
				
				answer = Math.min(answer, solveDistance(i));
			}
			
			System.out.print(answer);
			
		}catch(Exception e){e.printStackTrace();}
		

	}
	
	public static int solveDistance(int nth) {
		int xx = Math.abs(dots[0][0]-dots[nth][0]);
		int yy = Math.abs(dots[0][1]-dots[nth][1]);
		return xx*xx+yy*yy;
	}
	

}
