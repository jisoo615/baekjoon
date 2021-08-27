package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

//floyd-warshall �÷��̵� ���� 
/***�÷��̵�� ���ͽ�Ʈ��(�� �������� ������ ���������� �ּҰ��)�� �ٸ��� ��� �������� ��� ���� ������ �ּҰŸ��� ���Ѵ�.***/
public class p11404 {
	static final int INF = 1000000000;
	static int V, E, distance[][];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		distance = new int[V+1][V+1];

		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				if(i==j) {
					distance[i][j] = 0;
				}else {
					distance[i][j] = INF;
				}
			}
		}
		
		StringTokenizer st;
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			distance[u][v] = Math.min(distance[u][v], w);
		}
		
		floyd();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				int d = distance[i][j];
				if(d==0 || d==INF) {
					sb.append("0").append(" ");
				}else {
					sb.append(d).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		
	}
	
	static void floyd() {
		for(int mid = 1; mid<=V; mid++) {//������
			for(int start = 1; start<=V; start++) {//�����
				for(int end = 1; end<=V; end++) {//������
					distance[start][end] = Math.min( distance[start][end], distance[start][mid] + distance[mid][end]);
				}
			}
		}
		
	}
}
