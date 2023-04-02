/*
 * InsertionSort.java
 * 
 * Author: Jack Noyes
 * Date: 3/18/23
 * Instructor: Dr.Cates
 * Class: COMSC340
 *
 * Purpose: Sorts an array of different lengths in a nondecreasing sequence
 * 
 * 
 */




import java.util.Random;
import java.io.File;
import java.util.Scanner;

public class InsertionSortV2 {

	public static void main(String[] args) throws Exception{											//start main
		int count = 0;
		int[] array = new int[10000]; 														//makes an array of size fifteen
        File file = new File("rev10k.txt");
        Scanner scan = new Scanner(file);
        while(count < array.length){
            array[count] = scan.nextInt();
            count++;
        }
        scan.close();
        
        long start = System.nanoTime(); 												//starts clock
        insertionArray(array.length, array); 											//calling the method
        long end = System.nanoTime(); 													// stops clock
		long time = end - start; 
                                                                                        //calculates the time it took the algorithm to run in nanoseconds
        System.out.println("\nThe runtime for " + array.length + " amount of keys is: " + time + " nanoseconds"); 

	}																					//end main
	
	 /*
	 * InsertionArray - this is an insertion sort algorithm using arrays
	 * Parameters:  "length" is the length of the array that needs to be sorted
	 * 			   "unsort" is the unsorted array that needs to be sorted. 
	 * Output: A sorted array in a nondecreasing order
	 */
	
	static void insertionArray(int length, int[] unsort) {
		int i, j, x; 																	// these are indices to move through the array

		for(i=2; i < length; i++) { 													//This for going through the array at one index at a time starting at 2
			x = unsort[i];
			j = i-1; 
			while(j > 0 && unsort[j]>x) {
				unsort[j+1] = unsort[j];
				j--;
			}
			unsort[j+1]=x;
		}
		
		
	}																					//end insertionArray
}																						//end class


