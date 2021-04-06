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
		//hashSet���� �ߺ�����
		HashSet<String> set = new HashSet<String>(list);
		ArrayList<String> list2 = new ArrayList<>(set);
		
		Collections.sort(list2,new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length()==s2.length()) {
					return s1.compareTo(s2);//Ʋ������ ù ���ڸ� ���ؼ�-> �ι�° ���� ���ĵ� ���ϱ�
				}
				else {
					return s1.length() - s2.length();
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(String li : list2) {//�ߺ����ŷ� list2�� ���̰� list�� �޶����� ������ �̷��� �ؾߵ�.
			sb.append(li+"\n");
		}
		System.out.print(sb);
		
	}

}
