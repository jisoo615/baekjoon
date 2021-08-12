package dynamic_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2629 {
	static int n, weight[];//31
	static boolean dp[][];//31 30*500+1
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());	
		weight = new int[31];//이 배열이 0부터 값이 있는데 30이 아니라 31인 이유는, dfs에서 weight[i+1]하면 OutOfIndex에러 나서 weight[i]로 해줌
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		dp = new boolean[31][15001];//최대 구할 수 있는 크기는 = 모든 추의 합임.//31 sum+1
		
		dfs(0, 0);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			int bead = Integer.parseInt(st.nextToken());//bead = 구슬 = 물건의 무게
			if(bead > 15000) {//bead가 최대 구할 수 있는 크기(15000)보다 크면 무조건 N
				sb.append("N").append(" ");
				}
			else if(dp[n][bead]) {
				sb.append("Y").append(" ");
			}else {
				sb.append("N").append(" ");
			}
		}
		
		System.out.print(sb);

	}
	
	public static void dfs(int i, int w) {
		if( i>=n+1 ) return;//지나간적 없지만 i가 n보다 크면 종료(=i가 n보다 크면 종료해라)
		if(dp[i][w]) return;//구했던, true인 경우 종료.
		dp[i][w] = true;
		dfs(i+1, w+weight[i]);//추를 추 쪽에 올림		//여기서 추의 값은 같음' dp는 1부터 시작, weight는 0부터 시작이라서.
		dfs(i+1, Math.abs(w-weight[i]));//추를 구슬쪽에 추가
		dfs(i+1, w);//추를 저울에 놓지 않음
	}

}
