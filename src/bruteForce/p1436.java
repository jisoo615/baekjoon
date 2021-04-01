package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1436 {
//¿µÈ­°¨µ¶ ¼ò
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
		int n = Integer.parseInt(br.readLine());
		//666, 1666 2666 3666 4666 5666 6666 6661 6662 6663 6664 6665 6666 6667 6668 6669 7666 8666 9666
		//10666 11666 12666 13666 14666 15666 /16660 16661 16662 16663 16664 16665 16666 16667 16668 16669
		//17666 18666 19666
		int number = 666;
		int count = 1;
		while(count<n) {
			number++;
			if(String.valueOf(number).contains("666")) count++;
			
		}
		bw.write(number+"\n"); bw.flush();
		}catch (Exception e) {	e.printStackTrace();	}
	}

}
