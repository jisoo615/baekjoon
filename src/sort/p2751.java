package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2751 {
//합병정렬 Merge Sort
	//공동의 배열 arr, tmp 를 선언한다
	static int[] arr;
	static int[] tmp;
	public static void main(String[] args) {
		try(
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int num = Integer.parseInt(br.readLine());
			arr = new int[num];
			tmp = new int[num];
			for(int i=0; i<num; i++) {//입력
				arr[i] = Integer.parseInt(br.readLine());
			}
			merge_sort(0, num-1);
			
			for(int i=0; i<num; i++) {//출력
				bw.write(String.valueOf(arr[i])+"\n");
			}bw.flush();
		}catch (Exception e) {e.printStackTrace();}
	}
	
	public static void merge_sort(int start, int end) {//합병정렬
		if(start<end) {
			int mid = (start+end)/2; 
			merge_sort(start, mid); //만얄, 5/2하면 2.5->2이기 떄문에 -1해줄 필요 없음
			merge_sort(mid+1, end);
			//이제 인덱스가 돌아다니면서 값을 비교하고 자리를 바꿔줌
			
			int p= start;
            int q= mid+1;
            int idx= p; //tmp배열의 인덱스

            while(p<=mid || q<=end) { //인덱스가 p(처음~중간) or q(중간+1~끝) :arr[p]가 작으면 바꾸고 ++ 크면 기다리고(arr[p]>arr[q])될때까지..
                if(q>end || (p<=mid && arr[p]<arr[q])) { //q가 배열 밖에 있거나, p가 중간보다 앞에있고 p값보다 q값이 더 클때
                    tmp[idx++]= arr[p++]; //더 작은 걸 저장
                }else {
                    tmp[idx++]= arr[q++]; //q가 배열안에 있고, p는 아무렇게나고 arr[p]>arr[q] 일떄: arr[q]값이 더 작으니까 저장
                }
            }

            for(int i=start; i<=end; i++) {
                arr[i]=tmp[i];
            }			
		}
		return;
	}

}
