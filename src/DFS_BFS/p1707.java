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
			answer = "YES";//기본설정
			graph = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<V; i++) {
				graph.add(new ArrayList<Integer>() );
			}
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int p1 = Integer.parseInt(st.nextToken())-1;//arrayList가 인덱스 0부터 시작해서 -1 씩 해줘서 구함.
				int p2 = Integer.parseInt(st.nextToken())-1;
				graph.get(p1).add(p2);
				graph.get(p2).add((p1));
			}
			
			team = new int[V];//team은 빨강-1과 초록1, 미방문0 저장되어있는곳.
			for(int i=0; i<V; i++) {
				if(team[i]==0) {//방문안한 노드들을 bfs탐색함.
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
				if(team[i]==0) {//방문한 적이 없으면, 현재 노드와 반대색을 지정.
					team[i] = team[node] * -1; //-1을 곱하면 1은 -1이 되고 -1은 1이 되니까
					q.add(i);
				}
			}
			
		}
		return true;
	}

}
