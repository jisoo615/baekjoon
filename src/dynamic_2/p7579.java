package dynamic_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p7579 {
	static int N, M, dp[];
	static App apps[];
	
	static class App{
		int cost;
		int memory;
		public App(int memory, int cost) {
			this.memory = memory;
			this.cost = cost;
		}
		public int getMemory() {
			return memory;
		}
		public int getCost() {
			return cost;
		}
		public void setMemory(int memory) {
			this.memory = memory;
		}
		public void setCost(int cost) {
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());//새로운 앱이 필요로 하는 메모리 크기.
		
		apps = new App[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		int costSum = 0;
		
		for(int i=0; i<N; i++) {
			apps[i] = new App(0, 0);
			apps[i].setMemory(Integer.parseInt(st.nextToken()));
			int c = Integer.parseInt(st2.nextToken());
			costSum += c;
			apps[i].setCost(c);
		}
		
		dp = new int[costSum+1];
		
		for(int i=0; i<N; i++) {
			for(int j=costSum; j>=apps[i].getCost(); j--) {
				dp[j] = Math.max(dp[j], dp[j-apps[i].getCost()] + apps[i].getMemory());
			}
		}
		
		for(int i=0; i<=costSum; i++) {
			if(dp[i] >= M) {//메모리가 M이상 남아야 하는 최소 비용을 구하면 break;
				System.out.print(i);
				break;
			}
		}

	}

}
