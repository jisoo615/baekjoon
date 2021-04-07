package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class p10814_1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Person> list = new ArrayList<Person>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
		}

		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(list.get(i).age+" "+list.get(i).name+"\n");
		}System.out.println(sb);
	}
	
	public static class Person implements Comparable<Person>{
		int age;
		String name;
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	@Override
	public int compareTo(Person p) {
		if(this.age >= p.age) return 1;
		else return -1;
	}
}
	
}


