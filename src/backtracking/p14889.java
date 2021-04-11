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
	public static void combi(int indx, int count) {//�� ������
		if(count==N/2) {
			diff();//�湮���� ��湮���� �ɷ�ġ ���� ���ϱ�
			return;
		}
		
		for(int i=indx; i<N; i++) {// N/2�� �����ϱ�
			if(!visit[i]) {
				visit[i]=true;
				combi(i+1, count+1);
				visit[i]=false;
			}
		}
	}
//--------------------------------------------------------------------------------------------------------
	public static void diff() {//�� �ɷ�ġ ���� ���ϱ�
		int team_start=0; int team_link=0;
		for(int i=0; i<N-1; i++) {//n-1������ ���ƾߵ� �ȱ׷� j�� arr�Ѿ-����
			for(int j=i+1; j<N; j++) {
				if(visit[i]==true && visit[j]==true) {//��ŸƮ��
					team_start += (arr[i][j]+arr[j][i]);
				}
				else if(visit[i]==false && visit[j]==false) {//��ũ��
					team_link += (arr[i][j]+arr[j][i]);
				}
			}
		}
			int differ = Math.abs(team_start-team_link);
			
			//���� ���̰� 0�̸� ���̻� ���� �ʿ� ������ ����ϰ� ����
			if(differ==0) {
				min = 0;
				System.out.print(min);
				System.exit(0);
			}
			
			min = Math.min(min, differ);
		}

}
