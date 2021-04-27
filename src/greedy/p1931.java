package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
//종료시간이 빠를 순으로 정렬하고, 다음 시작 시간 >= 이전 종료시간 인 회의를 선택한다. 
public class p1931 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] meeting = new int[N][2];
		
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meeting, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]){//종료시간 같을 경우 시작시간 내림차순으로 정렬(빠른게 앞)
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
			
		});
		
		int count = 0;
		int prev_end_time = 0;
		for(int i=0; i<N; i++) {
			if(prev_end_time >= meeting[i][0]) {
				prev_end_time = meeting[i][1];
				count++;
			}
		}
		
		System.out.print(count);
		
	}

}
