package sort;

public class MergeSort {
	static void merge(int arr[], int first, int last) {
		int sort[] = new int[arr.length];	// arr�� ������ �����Ͽ� ������ �迭 ����
		
		int mid = (first + last) / 2;
		int leftidx = first;	// arr�� ���� �κ��� �����̴� index
		int rightidx = mid + 1;	// arr�� ������ �κ��� �����̴� index
		int sortidx = first;	// sort �迭�� index
		
		System.out.println("merge() ���� - first:"+first+", last:"+last);
        
        
		while (leftidx <= mid && rightidx <= last) {
        // leftidx�� rightidx �� �� �ϳ��� ������ ����� �� ���� ������ �����ٴ� ��
			if (arr[leftidx] <= arr[rightidx])	// ���� ���� �� ���� ��� �Ǵ� �� ���� ���� ���
				sort[sortidx++] = arr[leftidx++];	// ���� ���� sort�� ����, ���� index ����
			
			else						 		// ������ ���� �� ���� ���
				sort[sortidx++] = arr[rightidx++];	// ������ ���� sort�� ����, ������ index ����
		}
		// �ݵ�� ���ʰ� ������ �� ���� ������ ���� ����
	
		if (leftidx > mid) {  // ������ ������ ���� ���� ���
			for (int i = rightidx; i <= last; i++)	// ������ �κ��� ���� ������ ������� sort�� ����
				sort[sortidx++] = arr[i];
		}
		else	 {			  // �������� ������ ���� ���� ���
			for (int i = leftidx; i <= mid; i++) 	// ���� �κ��� ���� ������ ������� sort�� ����	
				sort[sortidx++] = arr[i];
		}
		
		for (int i = first; i <= last; i++) { 
			arr[i] = sort[i];		// ���� �Ϸ�� ������ ���� �迭�� ������� ����
		}
	}
	
	static void merge_sort(int arr[], int first, int last) {
		int mid = (first + last) / 2;
		
		// arr�� ũ�Ⱑ 1�� �Ǹ� if���� �������� �ʰ� ��ø�� ����Լ��� ���������� �����ϸ鼭 ũ�Ⱑ 1�� �Ǳ� ���� arr���� merge �޼ҵ尡 ����ȴ�.
		// merge_sort�� �ݺ� ���� : ���� - ������ - ��
		if (first < last) {	// arr�� ũ�Ⱑ 1�� �� ������ ������ ���� �ݺ�
			merge_sort(arr, first, mid);	// arr�� ���� �κ�
			merge_sort(arr, mid + 1, last);	// arr�� ������ �κ�
			merge(arr, first, last);	// arr�� ������������ ����
		}
	}
	
	
	public static void main(String[] args) {
		int arr[] = { 1,3,8,-2,2 };
		
		System.out.println("[�ʱ� �迭]");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println("\n");
		
		merge_sort(arr, 0, arr.length-1);	// arr�� ù index���� ������ index�� �Ѱ���
	
		System.out.println("\n[���ĵ� �迭]");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}