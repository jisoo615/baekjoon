package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p10814_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Person[] p = new Person[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p[i]=new Person(Integer.parseInt(st.nextToken()), st.nextToken());
		}

		Arrays.sort(p);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(p[i].age+" "+p[i].name+"\n");
		}System.out.println(sb);
		
	//두번째 출력방법 toSting으로
		for(int i=0; i<n; i++) {
			System.out.println(p[i]);//객체를 출력하면 자동으로 toString메소드 호출돼서 출력됨
		}
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
		//혹은 한줄로 =return this.age-p.age;
	}
	
	public String toString() {
		return this.age+" "+this.name;
	}
}

}
