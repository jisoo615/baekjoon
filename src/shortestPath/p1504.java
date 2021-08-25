package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1504 {
	//����� �׷����ε� ����׷������� �˾Ƽ� ��� Ʋ�Ⱦ���... �׷��� �������� ��������� �ߺ���
	static class Node implements Comparable<Node>{//static �ٿ���� ����Ŭ������ �ٷ� ���../�ֳ� ����������
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
			
		}

		@Override
		public int compareTo(Node o) {//��������
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
		
		distance = new int[V+1];
		Arrays.fill(distance, -1);//-1�� �ʱ�ȭ
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
			list[v].add(new Node(u, w));
		}
		st = new StringTokenizer(br.readLine(), " ");
		int via1 = Integer.parseInt(st.nextToken());
		int via2 = Integer.parseInt(st.nextToken());
		
		int[] pathA = new int[3]; int[] pathB = new int[3];
		dijkstra(1);
		pathA[0] = distance[via1];
		pathB[0] = distance[via2];
		dijkstra(via1);
		pathA[1] = distance[via2];//�״����� ���Ѱ� �� ������ -1�̾��� �Ҹ�(-1��)
		pathB[1] = distance[V];
		dijkstra(via2);
		pathA[2] = distance[V];
		pathB[2] = distance[via1];
		
		/***int case1 = dijkstra(1, via1) + dijkstra(via1, via2) + dijkstra(via2, V);
			int case2 = dijkstra(1, via2) + dijkstra(via2, via1) + dijkstra(via1, V);
		��� 3���� ���ͽ�Ʈ�� �����ؼ� ���� �� �ִ�. 6������ -> 3���������� ����
		via1���� �����ϸ� via1~via2, via1~V/ via2���� �����ϸ� via2~via1, via2~V/ 1���� �����ϸ� 1~via1, 1~via2, 1~V
		***/
		int sumA=0, sumB=0;
		for(int i=0; i<3; i++) {
			if(pathA[i]==-1) {
				sumA = -1;
				break;
			}else {
				sumA += pathA[i];
			}
		}
		for(int i=0; i<3; i++) {
			if(pathB[i]==-1) {
				sumB = -1;
				break;
			}else {
				sumB += pathB[i];
			}
		}
		
		if(sumA==-1 && sumB==-1) {
			System.out.print(-1);
		}else if(sumA==-1 || sumB==-1){
			System.out.println(sumA > sumB ? sumA : sumB);
		}else {
			System.out.println(sumA > sumB ? sumB : sumA);
		}
		
	}
	
	static public void dijkstra(int start) {//���� start���� �� ���������� �ּҰ�θ� ���ϴ� �޼ҵ�. distance�� ����
		Arrays.fill(distance, -1);//�Ÿ��� -1�� �ʱ�ȭ.
		Arrays.fill(visited, false);//�ʱ�ȭ
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visited[now.v]==false) {
				visited[now.v]=true;
				
				for(Node next : list[now.v]) {
					if(distance[next.v]==-1 || distance[next.v] > distance[now.v]+next.w) {
						distance[next.v] = distance[now.v]+next.w;
						pq.offer(new Node(next.v, distance[next.v]));
					}
				}//for end
			}
		}//while end
	}
}
