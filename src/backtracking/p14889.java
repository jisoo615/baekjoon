package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14889 {
	public static int N;
	public static int[][] arr;
	public static boolean[] visit;
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N];
		
			StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combi(0, 0);
		System.out.print(min);
	}
//--------------------------------------------------------------------------------------------------------
	public static void combi(int indx, int count) {//팀 나누기
		if(count==N/2) {
			diff();//방문팀과 비방문팀의 능력치 차이 구하기
			return;
		}
		
		for(int i=indx; i<N; i++) {// N/2명 선택하기
			if(!visit[i]) {
				visit[i]=true;
				combi(i+1, count+1);
				visit[i]=false;
			}
		}
	}
//--------------------------------------------------------------------------------------------------------
	public static void diff() {//팀 능력치 차이 구하기
		int team_start=0; int team_link=0;
		for(int i=0; i<N-1; i++) {//n-1까지만 돌아야됨 안그럼 j가 arr넘어감-오류
			for(int j=i+1; j<N; j++) {
				if(visit[i]==true && visit[j]==true) {//스타트팀
					team_start += (arr[i][j]+arr[j][i]);
				}
				else if(visit[i]==false && visit[j]==false) {//링크팀
					team_link += (arr[i][j]+arr[j][i]);
				}
			}
		}
			int differ = Math.abs(team_start-team_link);
			
			//만약 차이가 0이면 더이상 구할 필요 없으니 출력하고 종료
			if(differ==0) {
				min = 0;
				System.out.print(min);
				System.exit(0);
			}
			
			min = Math.min(min, differ);
		}

}
