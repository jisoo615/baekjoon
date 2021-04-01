package function;

public class p4673_selfnumber {
	
	static int d(int n) {
		int n_length = Integer.toString(n).length();
		int original = n;
		int sum = 0;
		for(int i=0; i<n_length; i++) {//각 자릿수 더하기
			int remain = n % 10;
			sum += remain;
			n = n/10;
		}
		n = sum+original; //원래 수 더하기
		return n;
	}
		
	public static void main(String[] args) {
		
		int[] notSelfNum = new int[10000];
		for(int i=0; i<10000; i++) {
			if(d(i)<10000) notSelfNum[d(i)] =1;  
			else continue;
		}
		for(int i=0; i<10000; i++) {
		if(notSelfNum[i] != 1)  System.out.println(i);
		}
	}
}