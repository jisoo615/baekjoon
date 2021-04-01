package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1018 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
		String[][] board = new String[N][M]; //세로 N 가로 M
		
		for(int i=0; i<N; i++) {
			board[i] = br.readLine().split("");			
		}//입력받은 보드판
		br.close();
		
		boolean[][] startWithW = {{true,false,true,false,true,false,true,false},
								{false,true,false,true,false,true,false,true},
								{true,false,true,false,true,false,true,false},
								{false,true,false,true,false,true,false,true},
								{true,false,true,false,true,false,true,false},
								{false,true,false,true,false,true,false,true},
								{true,false,true,false,true,false,true,false},
								{false,true,false,true,false,true,false,true}
								};//true : White, false : Black
		boolean[][] startWithB = {{false,true,false,true,false,true,false,true},
								{true,false,true,false,true,false,true,false},
								{false,true,false,true,false,true,false,true},
								{true,false,true,false,true,false,true,false},
								{false,true,false,true,false,true,false,true},
								{true,false,true,false,true,false,true,false},
								{false,true,false,true,false,true,false,true},
								{true,false,true,false,true,false,true,false}
								};
		int repaintW = 0; int repaintB = 0; int answer=0;
		int result =0; int temp = 64; String color = " "; boolean check;
		for(int k=0; k<N-7; k++){//시작점 조젛주는 값 가로로 움직이는
			for(int kk=0; kk<M-7; kk++ ) {//시작점 조절세로로 움직이는
				for(int i=0; i<8; i++) {
				for(int j =0; j<8; j++) {
					color = board[i+k][j+kk];
					if(color=="W") check = true;
					else check = false;
					
					if(check&&startWithW[i][j]) {repaintW+=1;}
					if(check&&startWithB[i][j]) {repaintB+=1;}
		}
		}		result = Math.min(64-repaintW,64-repaintB);
				if(result<temp) { temp=result; answer = result; }
				repaintW=0; repaintB=0;//한 케이스가 끝나면 다시 repaint 0으로 초기화	
		}		
			}
		bw.write(answer+"\n");
		bw.close();}catch (Exception e) {e.printStackTrace();}
	}

}
