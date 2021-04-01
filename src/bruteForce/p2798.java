package bruteForce;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2798 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{ 
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(st.nextToken());
			int[] cards = new int[size];
			int number = Integer.parseInt(st.nextToken());
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<size; i++) {
				cards[i] = Integer.parseInt(st2.nextToken());
		}
		br.close();
		//다른 세 수를 더한 거에 number를 넘지 않으면서 가장 큰 수 구해라..
		int compare = number;
		int result = 0;
		for(int i=0; i<size-2; i++) {//숫자A-마지막 두 수 남겨놔야 해서 2작게 돌아야됨
			for(int j=i+1; j<size-1; j++) {//숫자B
				for(int k=j+1; k<size; k++) {//숫자C
					int temp = number-(cards[i]+cards[j]+cards[k]);
					if(temp<=compare&&temp>=0) {
						compare = temp;
						result = number-compare;
					}
				}
			}
		}
		System.out.print(result);
		}catch(Exception e) { e.printStackTrace(); }
		}
	}
