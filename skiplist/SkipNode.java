package skiplist;

public class SkipNode {
	
	// storage for the node data
	private int data;
	
	// stroage for the address of the next node
	private SkipNode next;
	
	// storage for the address of the bottom node
	private Node bottom;
	
	// a no-argument constructor that creates a node with default values
	public SkipNode() {
		data = 0;
		next = null;
		bottom = null;
	}
	
	// get and set methods
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public SkipNode getNext() {
		return next;
	}
	
	public void setNext(SkipNode next) {
		this.next = next;
	}
	
	public Node getBottom() {
		return bottom;
	}
	
	public void setBottom(Node bottom) {
		this.bottom = bottom;
	}
}
