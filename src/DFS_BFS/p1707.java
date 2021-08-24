package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1707 {
	static ArrayList<ArrayList<Integer>> graph;
	static int visited[];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T, V, E;
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		while(T>0) {
			T--;
			graph = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<V; i++) {
				graph.add(new ArrayList<Integer>() );
			}
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				graph.get(p1).add(p2);
				graph.get(p2).add((p1));
			}
			
			
			
		}
		
	}

}
