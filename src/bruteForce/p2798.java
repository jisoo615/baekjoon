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
		//�ٸ� �� ���� ���� �ſ� number�� ���� �����鼭 ���� ū �� ���ض�..
		int compare = number;
		int result = 0;
		for(int i=0; i<size-2; i++) {//����A-������ �� �� ���ܳ��� �ؼ� 2�۰� ���ƾߵ�
			for(int j=i+1; j<size-1; j++) {//����B
				for(int k=j+1; k<size; k++) {//����C
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
