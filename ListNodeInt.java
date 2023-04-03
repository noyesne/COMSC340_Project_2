package LinkedList;

public class ListNodeInt {
    private int value; // The value stored in the node
    public ListNodeInt next; // The next node in the list
    
    // Constructor
    public ListNodeInt(int value) {
        this.value = value;
        this.next = null;
    }
    
    // Returns the value stored in the node
    public int getValue() {
        return value;
    }
    
    public void setNext(ListNodeInt next) {
    	this.next = next;
    }
    
    public void setValue(int value) {
    	this.value = value;
    }
    
    public ListNodeInt getNext() {
    	return this.next;
    }
}
