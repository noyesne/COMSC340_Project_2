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



package jswk;
import java.util.Random;

public class InsertionSort {

	public static void main(String[] args) {											//start main
		
		int[] array = new int[15]; 														//makes an array of size fifteen
		for(int i = 0; i < array.length; i++ ) {									 	//for loop to fill the array with random integers
			Random rand = new Random(); 												//Random object
			array[i] = rand.nextInt(); 													//fills array[i] with random integer
		}
		insertionArray(array.length, array); 											//calling the method
		
	}																					//end main
	
	 /*
	 * InsertionArray - this is an insertion sort algorithm using arrays
	 * Parameters: "length" is the length of the array that needs to be sorted
	 * 			   "unsort" is the unsorted array that needs to be sorted. 
	 * Output: A sorted array in a nondecreasing order
	 */
	
	static void insertionArray(int length, int[] unsort) {
		int i, j, x; 																	// these are indices to move through the array
		long start = System.nanoTime(); 												//starts clock
		for(i=2; i < length; i++) { 													//This for going through the array at one index at a time starting at 2
			x = unsort[i];
			j = i-1; 
			while(j > 0 && unsort[j]>x) {
				unsort[j+1] = unsort[j];
				j--;
			}
			unsort[j+1]=x;
		}
		long end = System.nanoTime(); 													// stops clock
		long time = end - start; 														//calculates the time it took the algorithm to run in nanoseconds
		System.out.println("\nThe runtime for " + length + " amount of keys is: " + time + " nanoseconds");
		
	}																					//end insertionArray
}																						//end class

