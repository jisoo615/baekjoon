package sort;

public class MergeSort {
	static void merge(int arr[], int first, int last) {
		int sort[] = new int[arr.length];	// arr의 값들을 정렬하여 저장할 배열 생성
		
		int mid = (first + last) / 2;
		int leftidx = first;	// arr의 왼쪽 부분을 움직이는 index
		int rightidx = mid + 1;	// arr의 오른쪽 부분을 움직이는 index
		int sortidx = first;	// sort 배열의 index
		
		System.out.println("merge() 실행 - first:"+first+", last:"+last);
        
        
		while (leftidx <= mid && rightidx <= last) {
        // leftidx와 rightidx 둘 중 하나라도 범위를 벗어나면 한 쪽은 정렬이 끝났다는 뜻
			if (arr[leftidx] <= arr[rightidx])	// 왼쪽 값이 더 작은 경우 또는 두 값이 같은 경우
				sort[sortidx++] = arr[leftidx++];	// 왼쪽 값을 sort에 저장, 왼쪽 index 증가
			
			else						 		// 오른쪽 값이 더 작은 경우
				sort[sortidx++] = arr[rightidx++];	// 오른쪽 값을 sort에 저장, 오른쪽 index 증가
		}
		// 반드시 왼쪽과 오른쪽 중 먼저 끝나는 곳이 있음
	
		if (leftidx > mid) {  // 왼쪽이 정렬이 먼저 끝난 경우
			for (int i = rightidx; i <= last; i++)	// 오른쪽 부분의 남은 값들을 순서대로 sort에 저장
				sort[sortidx++] = arr[i];
		}
		else	 {			  // 오른쪽이 정렬이 먼저 끝난 경우
			for (int i = leftidx; i <= mid; i++) 	// 왼쪽 부분의 남은 값들을 순서대로 sort에 저장	
				sort[sortidx++] = arr[i];
		}
		
		for (int i = first; i <= last; i++) { 
			arr[i] = sort[i];		// 정렬 완료된 값들을 원래 배열에 순서대로 저장
		}
	}
	
	static void merge_sort(int arr[], int first, int last) {
		int mid = (first + last) / 2;
		
		// arr의 크기가 1이 되면 if문을 실행하지 않고 중첩된 재귀함수를 빠져나오기 시작하면서 크기가 1이 되기 이전 arr에서 merge 메소드가 실행된다.
		// merge_sort의 반복 순서 : 왼쪽 - 오른쪽 - 위
		if (first < last) {	// arr의 크기가 1이 될 때까지 나누는 것을 반복
			merge_sort(arr, first, mid);	// arr의 왼쪽 부분
			merge_sort(arr, mid + 1, last);	// arr의 오른쪽 부분
			merge(arr, first, last);	// arr를 오름차순으로 정렬
		}
	}
	
	
	public static void main(String[] args) {
		int arr[] = { 1,3,8,-2,2 };
		
		System.out.println("[초기 배열]");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println("\n");
		
		merge_sort(arr, 0, arr.length-1);	// arr의 첫 index부터 마지막 index를 넘겨줌
	
		System.out.println("\n[정렬된 배열]");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}