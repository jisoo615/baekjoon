package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//양방향
public class p9370 {
	static final int INF = 10000000;
	static int n, m, t, s, g, h;
	static LinkedList<Node> list[];
	static int candidate[], distance[];
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		while(T>0) {
			T--;
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());//교차로 개수-정점
			m = Integer.parseInt(st.nextToken());//도로-가중치
			t = Integer.parseInt(st.nextToken());//후보군 개수
			
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());//시작점
			g = Integer.parseInt(st.nextToken());//거쳐야하는 교차로
			h = Integer.parseInt(st.nextToken());//거쳐야하는 교차로
			
			list = new LinkedList[n+1];
			distance = new int[n+1];
			visited = new boolean[n+1];
			candidate = new int[t];
			
			for(int i=1; i<=n; i++) {
				list[i] = new LinkedList<Node>();
			}
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				list[u].add(new Node(v, w));
				list[v].add(new Node(u, w));
			}
			
			for(int i=0; i<t; i++) {
				candidate[i] = Integer.parseInt(br.readLine());
			}
			
			
			int[][] result = new int[n+1][6+1];//s->t, s->g, s->h, g<->h, g->t, h->t
			dijkstra(s);//s->end, s->g, s->h
			for(int t : candidate) {//s->t, s->g, s->h
				result[t][1] = distance[t];
				result[t][2] = distance[g];
				result[t][3] = distance[h];
			}
			dijkstra(g);
			for(int t : candidate) {//g<->h, g->t
				result[t][4] = distance[h];
				result[t][5] = distance[t];
			}
			dijkstra(h);
			for(int t : candidate) {//h->t
				result[t][6] = distance[t];
			}
			
			int result1=0, result2=0, result3=0;
			ArrayList<Integer> answer = new ArrayList<>();
			for(int t : candidate) {
				result1 = result[t][1];//s->t
				result2 = result[t][3] + result[t][4] + result[t][5];//s->h + h->g + g->t
				result3 = result[t][2] + result[t][4] + result[t][6];//s->g + g->h + h->t
				
				if(result1==result2 || result1==result3) {//최단경로가 존재한다면
					answer.add(t);
				}
			}
			
			Collections.sort(answer);
			for(Integer x : answer) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			
		}//while(Testcase) end
		
		System.out.print(sb);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(distance, INF);//초기화
		Arrays.fill(visited, false);//초기화
		pq.add(new Node(start, 0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(visited[now.v]==false) {
				visited[now.v]=true;
				
				for(Node next : list[now.v]) {
					if( distance[next.v] > distance[now.v] + next.w) {
						distance[next.v] = distance[now.v] + next.w;
						pq.add(new Node(next.v, distance[next.v]));
					}
				}//for end
			}
		}//while end
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
