package algorithms;

import java.util.Random;

public class MergeSort {
	public static void main(String[] args) {											
		// gets an array of random integers
		int[] array = new int[15]; 														
		for(int i = 0; i < array.length; i++ ) {									 	
			Random r = new Random(); 											
			array[i] = r.nextInt(); 										
		}
		
		//calls merge sort algorithm
		mergeArray(array.length, array); 											
		
	}	
	
	static void mergeArray(int len, int[] arr) {
		if(len <= 1) {
			return;
		}
		
		// gets middle of array
		int mid = len / 2;
		// gets left side of array
		int[] left = new int[mid];
		// gets right side of array
		int[] right = new int[len - mid];
		
		// fills left and right side arrays with correct elements
		for(int i = 0; i < mid; i++) {
			left[i] = arr[i];
		}
		for(int i = mid; i < len; i++) {
			right[i - mid] = arr[i];
		}
		
		// keeps on merging each side until complete
		mergeArray(mid, left);
		mergeArray(len - mid, right);
		//merges both sides together
		merge(arr, left, right, mid, len - mid);
	}
	static void merge(int[] arr, int[] left, int[] right, int numL, int numR) {
		int a = 0, b = 0, c = 0;
		// while point in array is less than lengths of left and right array
		while(a < numL && b < numR) {
			// merges which ever side has the lower value
			if(left[a] <= right[b]) {
				arr[c++] = left[a++];
			} else {
				arr[c++] = right[b++];
			}
		}
		// if left or right side gets to the end of their array
		// then just full in the rest of the array with the given side
		while(a < numL) {
			arr[c++] = left[a++];
		}
		while(b < numR) {
			arr[c++] = right[b++];
		}
	}
	
}
