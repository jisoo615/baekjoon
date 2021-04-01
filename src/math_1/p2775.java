package math_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2775 {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int n = Integer.parseInt(br.readLine());
			int[] floor= new int[n]; int[] door= new int[n]; 
			for(int i=0; i<n; i++) {
				 floor[i] = Integer.parseInt(br.readLine());
				 door[i] = Integer.parseInt(br.readLine());
			}
			int fmax = floor[0]; int dmax = door[0];
			for(int i=0; i<n; i++) {
				if(floor[i]>fmax) fmax = floor[i];
				if(door[i]>dmax) dmax = door[i];
			}//필요한 최대의 호텔 크기 구하기
			fmax +=1; //맨 아래층은 0층이라서 +1해줌
			int[][] hotel = new int[fmax][dmax];
			for(int i=0; i<dmax; i++) {
				hotel[0][i] = i+1;
			}//0층 명수 설정
			
			for(int i=1; i<fmax; i++) {
				for(int j=0; j<dmax; j++) {
					if(j==0) hotel[i][j] = 1;//1호는 무슨 층이던간데 1임.
					else hotel[i][j] = hotel[i-1][j]+hotel[i][j-1]; //내 전집 호 + 내 밑층 호
				}
			}
			
			for(int i=0; i<n; i++) { bw.write(hotel[floor[i]][door[i]-1]+"\n"); }
			
			bw.flush();
		}catch(Exception e) {e.printStackTrace();}
		
	}

}
