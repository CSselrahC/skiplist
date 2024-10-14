package skiplist;

public class Node {
	
	// storage for the node data
	private int data;
	
	// storage for the address of the next node
	private Node next;
	
	// a no-argument constructor that creates a node with default values
	public Node() {
		data = 0;
		next = null;
	}
	
	// a constructor that creates a node with initial data specified by the parameter
	public Node(int data) {
		this.data = data;
		next = null;
	}
	
	// set and get methods
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
}
