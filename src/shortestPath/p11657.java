package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
//Ÿ�Ӹӽ�
public class p11657 {
	final static int INF = 1000000000;
	static int V, E;
	static LinkedList<Node> list[];
	static long distance[];
	static boolean visited[];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new LinkedList[V+1];
		distance = new long[V+1];
		visited = new boolean[V+1];
		
		for(int i=1; i<=V; i++) {
			distance[i] = INF;
			list[i] = new LinkedList<>();
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v, w));
		}
		
		StringBuilder sb = new StringBuilder();

		if( bellman(1)==false ) {//��������Ŭ�� �ƴ϶��
			for(int i=2; i<=V; i++) {
				sb.append(distance[i]==INF ? "-1" : distance[i]).append("\n");
			}
			
		}else {
			sb.append("-1").append("\n");
		}
		
		System.out.print(sb);
		//bellman-ford

	}
	
	
	static boolean bellman(int start) {
		boolean isUpdated = false;
		distance[start] = 0;
		
		for(int i=1; i<=V; i++) {//���� v-1�� ���� �ǵ� ��������Ŭ ���� �ľ� ���� �ѹ� �� ���� -> V�� ����.
			isUpdated = false;
			
			for(int j=1; j<=V; j++) {
				for(Node next : list[j]) {
					if(/**/distance[j] != INF /**/ && distance[next.v] > distance[j] + next.w ) {/*���� �������� distance�� INF�� �ƴҶ� ��!! ���� ��尡 �ƴ϶�*/
						distance[next.v] = distance[j] + next.w;
						isUpdated = true;
					}
				}
			}
			
			if(i==V) return isUpdated;//V��°�� ������Ʈ �Ǿ��ٸ� ��������Ŭ ����
		}
		return isUpdated;
	}
	
	
	static class Node implements Comparable<Node>{
		int v;
		int w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
	}

}
