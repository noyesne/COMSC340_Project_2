package algorithms;

import java.util.Random;
import java.io.File;
import java.util.Scanner;

public class MergeSortV3 {
	public static int counter = 0;
	public static void main(String[] args) throws Exception {											
		// gets an array of random integers
        int count = 0;
		int[] array = new int[100000]; 														//makes an array of size fifteen
        File file = new File("rev100k.txt");
        Scanner scan = new Scanner(file);

        while(count < array.length){
            array[count] = scan.nextInt();
            count++;
        }
        scan.close();
		//calls merge sort algorithm
        long start  = System.nanoTime();
		mergeArray(array.length, array); 											
		long end = System.nanoTime();
        long time = end - start; 
        System.out.println("\nThe runtime for " + array.length + " amount of keys is: " + time + " nanoseconds");
        System.out.println("\nAmount of comparisons is: " + counter);
	}	
	
	static void mergeArray(int len, int[] arr) {
		if(len <= 1) {
			counter++;
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
			counter++;
			left[i] = arr[i];
		}
		for(int i = mid; i < len; i++) {
			counter++;
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
			counter++;
			// merges which ever side has the lower value
			if(left[a] <= right[b]) {
				counter++;
				arr[c++] = left[a++];
			} else {
				counter++;
				arr[c++] = right[b++];
			}
		}
		// if left or right side gets to the end of their array
		// then just full in the rest of the array with the given side
		while(a < numL) {
			counter++;
			arr[c++] = left[a++];
		}
		while(b < numR) {
			counter++;
			arr[c++] = right[b++];
		}
	}
	
}
