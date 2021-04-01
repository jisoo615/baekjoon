package character_string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1316 {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int number = Integer.parseInt(br.readLine());
			
			int groupWord = number;
			
			for(int k=0; k<number; k++) {
				String s = br.readLine();
				int[] arr = new int[26];
				for(int i=0; i<s.length(); i++) { //한 단어씩 검사
					if(arr[s.charAt(i)-97]==0) {
						arr[s.charAt(i)-97] = 1; //완전처음 나온거면 1
					}
					else if(i>0 && s.charAt(i)==s.charAt(i-1) && arr[s.charAt(i)-97]==1) {//전에꺼랑 같으면 1
							arr[s.charAt(i)-97] = 1;
					}
					else {groupWord -=1; break;}
			}
			}
			bw.write(String.valueOf(groupWord)); //bw.write쓰기는 문자 출력이니까 바꿔서.. 아니면 +"\n"하거나
			bw.flush();
			
		}catch(Exception e) {e.printStackTrace();}

	}

}
