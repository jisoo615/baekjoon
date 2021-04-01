package recursion;
import java.io.*;
import java.util.*;
public class p2447_solution {
	static char[][] array;//전역변수 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		array = new char[N][N];
		for(int a=0;a<N;a++) {
			Arrays.fill(array[a],' '); //한줄씩 모두 공백처리
		}
		star(0,0,N);//함수 실행
		for(int a=0;a<N;a++) {
			System.out.println(array[a]);//배열을 모두 출력
		}
		br.close();
	}

	static void star(int x, int y, int num) { //별을 찍는 함수
		if(num==1) {
			array[x][y]='*'; //더이상 나눌 수 없는 수일때 그자리에 *을 넣는다.
			return;
		}
		int s = num/3;
		for(int a=0;a<3;a++) {
			for(int b=0;b<3;b++) {
				if(a == 1 && b == 1) {
					continue; // 바로 다음 반복문으로 넘기기 위한 키워드
				}
				System.out.println("star("+(x+s*a)+", "+(y+s*b)+", "+s+")");
				star(x+s*a,y+s*b, s);
			}
		}
	}
}