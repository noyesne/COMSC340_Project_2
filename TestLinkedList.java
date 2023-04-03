package run;
import LinkedList.LinkedListInt;
import LinkedList.ListNodeInt;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.System;

public class TestLinkedList {

	public static void main(String[] args) throws FileNotFoundException {
		String proceed = "n";
		int input = 1;
		Scanner kb = new Scanner(System.in);
		do {
			System.out.println("Which number type would you like to run? \n1.)Reverse Numbers \n2.)Random Numbers \n3.)Inorder Numbers");
			input = kb.nextInt();
			
			switch(input) {
				case(1):
					linkedSort("rev");
					break;
				case(2):
					linkedSort("random");
					break;
				case(3):
					linkedSort("inorder");
					break;
				
			}
			
			
			System.out.println("Would you like to contine? ");
			//Throw away line. Because kb.nextInt is dumb and gets rid of the next
			//kb.nextLine call
			kb.nextLine();
			proceed = kb.nextLine();
		}while(proceed.equalsIgnoreCase("y"));

	}
	
	public static void linkedSort(String filename) throws FileNotFoundException {
		String currentfilename;
		File f;
		Scanner file = new Scanner("random5k.txt");
		System.out.println("This Method returns the runtime of all numbers in the order you selected \n(Ex. if you selected inorder it will return the runtime of inorder5k, inorder10k, and inorder100k all at once) \nThese will all be timed seperately and recorded properly. But keep in mind it will take some time to complete, so grab a drink or something :)");
		String size = "5k";
		for(int i = 0; i < 3; i++) {
			LinkedListInt sort = new LinkedListInt();
			
			if(i == 0) {
				currentfilename = String.format(filename + "%s", "5k.txt");
				f = new File(currentfilename);
				file = new Scanner(f);
				size = "5k";
			}
			
			if(i == 1) {
				currentfilename = String.format(filename + "%s", "10k.txt");
				f = new File(currentfilename);
				file = new Scanner(f);
				size = "10k";
			}
			if(i == 2) {
				currentfilename = String.format(filename + "%s", "100k.txt");
				f = new File(currentfilename);
				file = new Scanner(f);
				size = "100k";
			}
			
			while(file.hasNextInt()) {
				sort.addLast(file.nextInt());
			}
			System.out.println(String.format("%s Unsorted Numbers: ", size));
			System.out.println(sort.toString());
			System.out.println(String.format("%s Sorted Numbers: ", size));
			long result = insertionSort(sort);
			System.out.print(String.format("%s Total Sorting Time: ", size));
			System.out.println(result);
		}
	}
	
	public static long insertionSort(LinkedListInt list) {
	    long startTime = System.nanoTime(); //START TIMING. BEGINING OF INSERSION SORT
		if (list == null || list.isEmpty()) {
	        return 0;
	    }
	    
	    // Create a dummy head node
	    ListNodeInt dummyHead = new ListNodeInt(0);
	    dummyHead.next = list.head;

	    ListNodeInt lastSorted = dummyHead.next; // The last node that has been sorted
	    ListNodeInt curr = lastSorted.next; // The current node being sorted
	    while (curr != null) {
	        if (curr.getValue() < lastSorted.getValue()) {
	            // Find the correct position to insert curr
	            ListNodeInt prev = dummyHead;
	            while (prev.next.getValue() < curr.getValue()) {
	                prev = prev.next;
	            }
	            
	            // Remove curr from its current position
	            lastSorted.next = curr.next;
	            
	            // Insert curr into its correct position
	            curr.next = prev.next;
	            prev.next = curr;
	            
	            // Move curr to the next unsorted node
	            curr = lastSorted.next;
	        } else {
	            // No need to sort curr, move to the next unsorted node
	            lastSorted = lastSorted.next;
	            curr = curr.next;
	        }
	    }
	    
	    // Update the LinkedList with the sorted nodes
	    list.addFirst(dummyHead.next);
	    long endTime = System.nanoTime(); //FINISH TIMING. END OF INSERTION SORT
	    System.out.println(list.toString());
	    return endTime - startTime;
	    
	}

}
