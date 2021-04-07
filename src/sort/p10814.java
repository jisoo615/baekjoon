package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p10814 {
//나이순 정렬
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[][] arr = new String[n][2];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		
		Arrays.sort(arr, (e1, e2)->{
			if(Integer.parseInt(e1[0])==Integer.parseInt(e2[0])) {
				return 0;
			}
			else {
				return Integer.parseInt(e1[0])-Integer.parseInt(e2[0]);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(arr[i][0]+" "+arr[i][1]+"\n");
		}
		System.out.print(sb);
		
		
//comparator 인터페이스 compare메소드 람다식 안쓰고 오버라이드 하기
		Arrays.sort(arr, new Comparator<String[]>(){
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0])-Integer.parseInt(s2[0]);
			}
		});
		StringBuilder sb_1 = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb_1.append(arr[i][0]+" "+arr[i][1]+"\n");
		}
		System.out.print(sb_1);
	}
}
