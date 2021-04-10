package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14888 {
	public static int mx=Integer.MIN_VALUE;
	public static int mini=Integer.MAX_VALUE;
	public static int[] operators;
	public static int[] number;
	public static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		number = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {//¼ö¿­
			number[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		operators = new int[4];//µ¡¼Á »¬¼À °ö¼À ³ª´°¼À
		for(int i=0; i<4; i++) {
			operators[i]=Integer.parseInt(st.nextToken());
		}
		
		dfs(number[0], 1);//¼ýÀÚ´Â ¿¬»êÀÚº¸´Ù 1°³ ´õ ¸¹±â ¶§¹®¿¡ 1ºÎÅÍ ½ÃÀÛÇØ¾ßµÊ. (ÀÎµ¦½º°¡ number[] ÀÎµ¦½ºÀÓ)
		System.out.println(mx);
		System.out.println(mini);
	}
	
	public static void dfs(int num, int index) {
		if(index == N) {
			mx = Math.max(mx, num);
			mini = Math.min(mini, num);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(operators[i]>0) {
				operators[i]--;
				switch(i) {
				case 0: dfs(num + number[index], index+1); break;
				case 1: dfs(num - number[index], index+1); break;
				case 2: dfs(num * number[index], index+1); break;
				case 3: dfs(num / number[index], index+1); break;
				}
				
				//Àç±ÍÈ£Ãâ ³¡³ª¼­ µ¹¾Æ¿À¸é ¿ø»óº¹±¸ÇØÁà¾ß ÇÔ.
				operators[i]++;
			}
		}
	}

}
