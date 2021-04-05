package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//merge sort를 사용했지만 최빈값 구할 수 없었음..
public class p2108 {
	static int[] tmp;
	static int[] data;
	public static void main(String[] args) {
		try(	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int n = Integer.parseInt(br.readLine());
			data = new int[n];
			tmp = new int[n];
			for(int i=0; i<n; i++) {
				data[i] = Integer.parseInt(br.readLine());
			}
			merge_sort( 0, n-1);
			int sum = 0; int middle=n/2;/*가운데 인덱스*/
			//int temp =0; int mode = 0; //mode는 최빈값, temp는 임시 
			//최빈값:최빈값이 여러개 있을때에는 두번째로 작은 값을 출력한다//hash맵과 iterator를 가지고 풀어야 함.(int배열로 구할거 아니면)

			for(int i=0; i<n; i++) {
				sum +=data[i];
			}
		
			bw.write(String.valueOf((int)Math.round((double)sum/n))+"\n"
				+String.valueOf(data[middle])+"\n"
				+String.valueOf(" 못구했음 ")+"\n"
				+String.valueOf(data[n-1]-data[0])+"\n");
			bw.flush();
		}catch (Exception e) { e.printStackTrace();	}

	}
	
	
	public static void merge( int start, int end) {
		int mid = (start+end)/2;
		int leftindx = start;
		int rightindx = mid+1;
		int tmpindx = start; //임시배열에 저장할때 쓸 인덱스
		
		while(leftindx<=mid && rightindx<=end) {
			if(data[leftindx]>data[rightindx]) tmp[tmpindx++] = data[rightindx++];
			else if(data[leftindx]<data[rightindx]) tmp[tmpindx++] = data[leftindx++];
			else {//값이 같은 경우
				tmp[tmpindx++] = data[leftindx++];
				tmp[tmpindx++] = data[rightindx++];
			}
		}//왼쪽이나 오른쪽 하나라도 끝나면 while문을 나온다. 그래서 아래 if else 문이 필요
		
		if(leftindx>mid) {//left가 먼저 끝났으면
			for(int i=rightindx; i<=end; i++) { tmp[tmpindx++] = data[i]; }//오른쪽 남은거 주르륵 저장
		}
		else if(rightindx>end) {//right가 먼저 끝났으면
			for(int i=leftindx; i<=mid; i++) { tmp[tmpindx++] = data[i]; }//왼쪽 남은거 주르륵 저장
		}
		
		//마지막으로 tmp에 정렬된 것을 data로 옮겨야 함
		for(int i=start; i<=end; i++) {
			data[i] = tmp[i];
		}			
	}
	
	
	public static void merge_sort( int start, int end) {
		int mid = (start+end)/2;
		if(start<end) {//while로 할때 안되더니 if로 바꾸니까 됐음 뭐지??
			merge_sort( start, mid);
			merge_sort( mid+1, end);
			merge( start, end);
		}
	}

}
