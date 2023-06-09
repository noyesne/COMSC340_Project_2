package LinkedList;
import java.util.NoSuchElementException;


public class LinkedListInt {
    public ListNodeInt head; // The first node in the list
    
    // Constructor
    public LinkedListInt() {
        this.head = null;
    }
    
    // Returns true if the list is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    // Adds a new node to the beginning of the list
    public void addFirst(int value) {
        ListNodeInt newNode = new ListNodeInt(value);
        newNode.next = head;
        head = newNode;
    }
    
    // Adds a new node to the end of the list
    public void addLast(int value) {
        ListNodeInt newNode = new ListNodeInt(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            ListNodeInt curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }
    
    // Removes and returns the first node in the list
    public int removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int value = head.getValue();
        head = head.next;
        return value;
    }
    
    // Returns the first node in the list
    public int getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.getValue();
    }
    
    // Returns a string representation of the list
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNodeInt curr = head;
        while (curr != null) {
            sb.append(curr.getValue()+"");
            if (curr.next != null) {
                sb.append(", ");
            }
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

	public void addFirst(ListNodeInt next) {
		head = next;
		
	}
}