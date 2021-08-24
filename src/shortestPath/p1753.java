package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1753 {
	static class Node implements Comparable<Node>{//static 붙여줘야 내부클래스로 바로 사용../왜냐 오류났었음
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
			
		}

		@Override
		public int compareTo(Node o) {//오름차순
			return w - o.w;
		}
	}
	
	static LinkedList<Node> list[];
	static int distance[];
	static boolean visited[];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		distance = new int[V+1];
		Arrays.fill(distance, -1);//-1로 초기화
		visited = new boolean[V+1];
		list = new LinkedList[V+1];
		
		for(int i=1; i<=V; i++) {
			list[i] = new LinkedList<Node>();//
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new Node(v, w));
		}
		
		dijkstra(start);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			sb.append(distance[i]==-1 ? "INF" : distance[i]).append("\n");
		}
		System.out.print(sb);
	}
	
	static public void dijkstra(int n) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(n, 0));
		distance[n] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visited[ now.v ]==false) {
				visited[ now.v ]=true;
				for(Node next : list[now.v]) {
					
					if(distance[next.v]==-1 || distance[next.v] > distance[now.v] + next.w ) {
						distance[next.v] = distance[now.v] + next.w;
						pq.offer(new Node(next.v, distance[next.v]));//이젠 next.w가 아니라 distance[next.w]의 값을 가중치로 저장해야됨.
					}
				}//for end
			}
		}//while end
	}

}
