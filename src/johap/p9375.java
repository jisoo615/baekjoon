package johap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p9375 {

	public static void main(String[] args) throws IOException{
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			int nn = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			
			for(int j=0; j<nn; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				String Key = st.nextToken();
				if(map.containsKey(Key)) {
					map.put(Key, map.get(Key)+1);
				}
				else {
					map.put(Key, 1);
				}
				
			}
			
				int result =1;
				for(int val : map.values()) {
					result *= (val+1);
				}
				sb.append(result-1).append("\n");
		}
		
		System.out.print(sb);

	}

}
