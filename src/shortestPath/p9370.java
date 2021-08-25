package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
//�����
public class p9370 {
	static int n, m, t, s, g, h;
	static LinkedList<Node> list[];
	static int candidate[], distance[];
	static boolean visited[];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		while(T>0) {
			T--;
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());//������ ����-����
			m = Integer.parseInt(st.nextToken());//����-����ġ
			t = Integer.parseInt(st.nextToken());//�ĺ��� ����
			
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
			
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());//������
			g = Integer.parseInt(st.nextToken());//���ľ��ϴ� ������
			h = Integer.parseInt(st.nextToken());//���ľ��ϴ� ������
			
			for(int i=0; i<t; i++) {
				candidate[i] = Integer.parseInt(br.readLine());
			}
			
			
			
		}
	}
	
	static class Node implements Comparable<Node>{
		int v, w;
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
