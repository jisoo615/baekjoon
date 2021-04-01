package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p7568 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		try {
		int number = Integer.parseInt(br.readLine());
		int[][] arr = new int[number][2];
		for(int i=0; i<number; i++) { //배열에 넣고 arr[][2]자리엔 등수를 넣을 거임--수정됨: rank로 바로바로 출력하기로함
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken()); 
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<number; i++) {
			int rank=1;
			for(int j=0; j<number; j++) {
				if(i==j) continue;
				if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]) rank += 1; //비교할 것보다 작으면 i의 rank에 +1하기
			}
			bw.write(rank+"\n");
		}
		bw.flush();
		}catch (Exception e) {e.printStackTrace();}
	}

}
