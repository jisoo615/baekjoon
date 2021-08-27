package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
//타임머신
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

		if( bellman(1)==false ) {//음수싸이클이 아니라면
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
		
		for(int i=1; i<=V; i++) {//원랜 v-1번 도는 건데 음수싸이클 유무 파악 위해 한번 더 돌림 -> V번 돌림.
			isUpdated = false;
			
			for(int j=1; j<=V; j++) {
				for(Node next : list[j]) {
					if(/**/distance[j] != INF /**/ && distance[next.v] > distance[j] + next.w ) {/*주의 현재노드의 distance가 INF가 아닐때 임!! 다음 노드가 아니라*/
						distance[next.v] = distance[j] + next.w;
						isUpdated = true;
					}
				}
			}
			
			if(i==V) return isUpdated;//V번째에 업데이트 되었다면 음수싸이클 존재
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
