package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//KCM travel 
//단뱡향, 
public class p10217 {
		static final int INF = 987654321;
		static int N, M, K, time[][];
		static LinkedList<Airport> list[];
		static boolean visited[];

		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st;
			StringBuilder sb= new StringBuilder();
			while(T>0) {
				T--;
				st = new StringTokenizer(br.readLine(), " ");
				N = Integer.parseInt(st.nextToken());//공항 수 V
				M = Integer.parseInt(st.nextToken());//총 지원 비용
				K = Integer.parseInt(st.nextToken());//티켓 정보수 E
				
				list = new LinkedList[N+1];
				time = new int[N+1][M+1];//N번 정점까지 M비용이 들었을때의 소요시간
				visited = new boolean[N+1];
				for(int i=1; i<=N; i++) {
					list[i] = new LinkedList<Airport>();
					Arrays.fill(time[i], INF);
				}
				for(int i=0; i<K; i++) {
					st = new StringTokenizer(br.readLine(), " ");
					int u = Integer.parseInt(st.nextToken());
					int v = Integer.parseInt(st.nextToken());
					int c = Integer.parseInt(st.nextToken());
					int t = Integer.parseInt(st.nextToken());
					list[u].add(new Airport(v, c, t));
				}
				
				int answer = dijkstra();
				sb.append(answer==INF ? "Poor KCM" : answer).append("\n");
				
			}
			System.out.print(sb);
	}
		
		static int dijkstra() {			
			PriorityQueue<Airport> pq = new PriorityQueue<>();
			pq.offer(new Airport(1, 0, 0));
			visited[1] = true; time[1][0] = 0;
			
			while(!pq.isEmpty()) {
				Airport now = pq.poll();
				int nowPort = now.v;
				int nowCost = now.c;
				int nowTime = now.t;
				if(time[nowPort][nowCost] < nowTime) continue;//
					for(Airport next : list[nowPort]) {
						int nextPort = next.v;
						int nextCost = nowCost + next.c;
						int nextTime = nowTime + next.t;
						if( nextCost <= M && time[nextPort][nextCost] > nextTime) {
							time[nextPort][nextCost] = nextTime;
							pq.offer(new Airport(nextPort, nextCost, nextTime));
						}
					}
			}
			int min = time[N][0];//N에 도착했을때 0비용이 든 경로의 소요시간
			for(int i=1; i<=M; i++) {
				min = Math.min(min, time[N][i]);
			}
			return min;
		}
		
		static class Airport implements Comparable<Airport>{
			int v, c, t;
			
			public Airport(int end, int c, int t) {
				this.v = end;
				this.c = c;
				this.t = t;
			}

			@Override
			public int compareTo(Airport o) {
				return c-o.c;
			}
		}

}
