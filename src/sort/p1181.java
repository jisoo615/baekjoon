package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class p1181 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			list.add(br.readLine());
		}
		//hashSet으로 중복제거
		HashSet<String> set = new HashSet<String>(list);
		ArrayList<String> list2 = new ArrayList<>(set);
		
		Collections.sort(list2,new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length()==s2.length()) {
					return s1.compareTo(s2);//틀린이유 첫 글자만 비교해서-> 두번째 글자 이후도 비교하기
				}
				else {
					return s1.length() - s2.length();
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(String li : list2) {//중복제거로 list2의 길이가 list와 달라졌기 때문에 이렇게 해야됨.
			sb.append(li+"\n");
		}
		System.out.print(sb);
		
	}

}
