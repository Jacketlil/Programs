
public class UpdatedHeapSort {

	public static void main(String[] args) {
		int arr[] = { 2, 8, 5, 3, 9, 1 };
		int n = arr.length;
		System.out.println("Unsorted array is: ");
		for ( int i = 0; i < n ; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println();
		
		sort(arr);
		
		System.out.println("Sorted array is: ");
		printArray(arr, n);
		

	}
	
	public static void sort(int arr[]) {
		int n = arr.length;
		
		for (int i = n/2 - 1 ; i >= 0 ; i--) {
			heapify(arr, n, i);
		}
		
		for (int n1 = n - 1 ; n1 > 0 ; n1--) {
			int temp = arr[0];
			arr[0] = arr[n1];
			arr[n1] = temp;
			printArray(arr, 6);
			
			heapify(arr, n1, 0);
		}
	}

	
	static void heapify(int arr[], int n, int i) {
		
		int largest = i;
		int leftChil = 2*i +1;
		int rightChil = 2*i +2;
		
		if(leftChil < n && arr[leftChil] > arr[largest]) {
			largest = leftChil;
		}
		
		
		if(rightChil < n && arr[rightChil] > arr[largest]) {
			largest = rightChil;
		}
		
		if(largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			printArray(arr, 6);
			
			heapify(arr, n, largest);
		}
	}
	
	static void printArray(int arr[], int n) {
		for ( int i = 0; i < n ; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
