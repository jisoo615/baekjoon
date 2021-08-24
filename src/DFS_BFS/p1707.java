package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1707 {
	static ArrayList<ArrayList<Integer>> graph;
	static int team[];
	static String answer;
	static int RED=- 1, GREEN = 1;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T, V, E;
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		while(T>0) {
			T--;
			answer = "YES";//�⺻����
			graph = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<V; i++) {
				graph.add(new ArrayList<Integer>() );
			}
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int p1 = Integer.parseInt(st.nextToken())-1;//arrayList�� �ε��� 0���� �����ؼ� -1 �� ���༭ ����.
				int p2 = Integer.parseInt(st.nextToken())-1;
				graph.get(p1).add(p2);
				graph.get(p2).add((p1));
			}
			
			team = new int[V];//team�� ����-1�� �ʷ�1, �̹湮0 ����Ǿ��ִ°�.
			for(int i=0; i<V; i++) {
				if(team[i]==0) {//�湮���� ������ bfsŽ����.
					if(!bfs(i)) break;
				}
			}
			
			System.out.println(answer);
		}
	}
	
	static public boolean bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		team[n] = RED;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(Integer i : graph.get(node)) {
				if(team[i]==team[node]) {
					answer = "NO";
					return false;
				}
				if(team[i]==0) {//�湮�� ���� ������, ���� ���� �ݴ���� ����.
					team[i] = team[node] * -1; //-1�� ���ϸ� 1�� -1�� �ǰ� -1�� 1�� �Ǵϱ�
					q.add(i);
				}
			}
			
		}
		return true;
	}

}
